package com.ego.serviceimpl;

import com.ego.commons.ResponseData.StatusData;
import com.ego.domain.TbItemParam;
import com.ego.domain.TbItemParamItem;
import com.ego.service.ItemParamListService;
import com.ego.serviceimpl.dao.TbItemCatMapper;
import com.ego.serviceimpl.dao.TbItemParamMapper;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@DubboService(interfaceClass = ItemParamListService.class, version = "1.0", timeout = 5000)
public class ItemParamListServiceImpl implements ItemParamListService {

    @Resource
    private TbItemParamMapper tbItemParamMapper;

    @Resource
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemParam> findList(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectAll();
        for (TbItemParam tb : tbItemParams) {
            tb.setItemCatName(tbItemCatMapper.selectByPrimaryKey(tb.getItemCatId()).getName());
        }
        return tbItemParams;
    }

    @Override
    @Transactional
    public StatusData deleteParam(String ids) throws RuntimeException{
        StatusData statusData = new StatusData();
        String[] strings = ids.split(",");
        int count = 0;
        for (String id:strings) {
            count = tbItemParamMapper.deleteByPrimaryKey(Long.parseLong(id)) + count;
        }
        if(count == strings.length){
            statusData.setStatus(200);
        }else
            throw new RuntimeException("删除失败");
        return statusData;
    }

    @Override
    public StatusData getStatusData(long id) {
        StatusData statusData = new StatusData();
        statusData.setData(tbItemParamMapper.selectByCId(id));
        statusData.setStatus(200);
        return statusData;
    }
}
