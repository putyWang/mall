package com.ego.serviceimpl.itemCatServiceImpl;

import com.ego.domain.TbItemCat;
import com.ego.service.ItemCatService;
import com.ego.serviceimpl.dao.TbItemCatMapper;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

@DubboService(interfaceClass = ItemCatService.class, version = "1.0", timeout = 5000)
public class ItemCatServiceImpl implements ItemCatService {

    @Resource
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> showItemCat(long pid) {

        TbItemCat tbItemCat = new TbItemCat();
        tbItemCat.setParentId(pid);
        return tbItemCatMapper.selectByTbItemCat(tbItemCat);
    }
}
