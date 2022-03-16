package com.ego.serviceimpl;

import com.ego.commons.utils.CreatIdUtil;
import com.ego.commons.utils.HttpClientUtils;
import com.ego.domain.*;
import com.ego.service.ListService;
import com.ego.serviceimpl.dao.*;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.DubboService;
import com.ego.commons.ResponseData.StatusData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DubboService(interfaceClass = ListService.class,version = "1.0", timeout = 50000)
public class ListServiceImpl implements ListService {

    @Resource
    private TbItemMapper tbItemMapper;

    @Resource
    private TbItemDescMapper tbItemDescMapper;

    @Resource
    private TbItemParamItemMapper tbItemParamItemMapper;

    @Resource
    private TbItemCatMapper tbItemCatMapper;

    @Resource
    private HttpClientUtils httpClientUtils;

    @Value("${http.addUrl}")
    private String addUrl;

    @Value("${http.delUrl}")
    private String delUrl;

    @Override
    public List<TbItem> findList(int page, int rows) {
        PageHelper.startPage(page, rows);
        return tbItemMapper.selectAll();
    }

    @Override
    public List<TbItem> findListByStatus(int status) {
        return tbItemMapper.selectAllByStatus(status);
    }

    /**
    *@Description: 更新商品状态（上架，下架或者删除）
    *@Param:
    *@return:
    */
    @Override
    @Transactional
    public StatusData updateStatus(String ids, int status) throws RuntimeException {
        Map<String, Object> map;
        StatusData statusData = new StatusData();
        String[] strings = ids.split(",");
        int count = 0;
        for (String id:strings) {
            count = tbItemMapper.updateStatusByPrimaryKey(Long.parseLong(id),status) + count;

            map = new HashMap<>();
            try {
                if(status == 1) {
                    map.put("tbItem", tbItemMapper.selectByPrimaryKey(Long.parseLong(id)));
                    map.put("desc", tbItemDescMapper.selectByPrimaryKey(Long.parseLong(id)).getItemDesc());
                    map.put("tbItemCatName", tbItemCatMapper.selectByPrimaryKey(tbItemMapper.selectByPrimaryKey(Long.parseLong(id)).getCid()).getName());
                    count += Integer.valueOf(httpClientUtils.doPost(addUrl, map).getBody());
                }
                else {
                    map.put("tbItemId", Long.valueOf(id));
                    count += Integer.valueOf(httpClientUtils.doPost(delUrl, map).getBody());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(count == strings.length * 2){
            statusData.setStatus(200);
        }else
            throw new RuntimeException("添加失败");
        return statusData;
    }

    /**
    *@Description: 增加商品
    *@Param:
    *@return:
    */
    @Override
    @Transactional
    public StatusData SaveItem(TbItem tbItem, String dec, String itemParams) throws RuntimeException{

        TbItemDesc tbItemDesc = new TbItemDesc();
        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        StatusData statusData = new StatusData();
        Long id = CreatIdUtil.getId();
        int count = 0;
        tbItem.setStatus(1);
        tbItem.setId(id);
        LocalDateTime date = LocalDateTime.now();
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        tbItemDesc.setItemId(tbItem.getId());
        tbItemDesc.setItemId(id);
        tbItemDesc.setItemDesc(dec);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        tbItemParamItem.setItemId(id);
        tbItemParamItem.setParamData(itemParams);
        tbItemParamItem.setCreated(date);
        tbItemParamItem.setUpdated(date);
        count += tbItemMapper.insert(tbItem);
        count += tbItemDescMapper.insert(tbItemDesc);
        count += tbItemParamItemMapper.insert(tbItemParamItem);

        Map<String, Object> map = new HashMap<>();
        map.put("tbItem", tbItem);
        map.put("desc", dec);
        map.put("tbItemCatName", tbItemCatMapper.selectByPrimaryKey(tbItem.getCid()).getName());
        System.out.println(map);
        try {
            count += Integer.valueOf(httpClientUtils.doPost(addUrl, map).getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count == 4){
            statusData.setStatus(200);
        }else
            throw new RuntimeException("数据问题，取消添加" );
        return statusData;
    }

    @Override
    public TbItemDesc findTbItemDescById(long id) {
        return tbItemDescMapper.selectByPrimaryKey(id);
    }

    @Override
    public TbItemCat findTbItemCatById(long id) {
        return tbItemCatMapper.selectByPrimaryKey(id);
    }

    @Override
    public TbItem findTbItemById(long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }



}
