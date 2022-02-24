package com.ego.serviceimpl;

import com.ego.domain.TbItem;
import com.ego.service.ListService;
import com.ego.serviceimpl.dao.TbItemMapper;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.DubboService;
import com.ego.commons.StatusData;

import javax.annotation.Resource;
import java.util.List;

@DubboService(interfaceClass = ListService.class,version = "1.0", timeout = 500)
public class ListServiceImpl implements ListService {

    @Resource
    private TbItemMapper tbItemMapper;

    @Override
    public List<TbItem> findList(int page, int rows) {

        PageHelper.startPage(page, rows);
        return tbItemMapper.selectAll();
    }

    @Override
    public StatusData updateStatus(String ids, int status) {
        StatusData statusData = new StatusData();
        String[] strings = ids.split(",");
        int count = 0;
        for (String id:strings) {
            count = tbItemMapper.updateStatusByPrimaryKey(Long.parseLong(id),status) + count;
        }
        if(count == strings.length){
            statusData.setStatus(200);
        }
        return statusData;
    }

}
