package com.ego.manage.controller;

import com.ego.commons.EasyUIDataGrid;
import com.ego.commons.StatusData;
import com.ego.domain.TbItem;
import com.ego.service.ListService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ListItemController {
    @DubboReference(interfaceClass = ListService.class, version = "1.0")
    private ListService listService;

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGrid list(@RequestParam("page") int page ,
                             @RequestParam("rows") int rows){

        PageInfo<TbItem> pi = new PageInfo<>(listService.findList(page,rows));
        EasyUIDataGrid easyUIDataGrid = new EasyUIDataGrid();
        easyUIDataGrid.setRows(pi.getList());
        easyUIDataGrid.setTotal(pi.getTotal());
        return easyUIDataGrid;
    }
    //删除商品
    @RequestMapping("/rest/item/delete")
    @ResponseBody
    public StatusData delete( String ids){
        StatusData data = new StatusData();
        return listService.updateStatus(ids,3);
    }
    //上架商品
    @RequestMapping("/rest/item/reshelf")
    @ResponseBody
    public StatusData reShelf( String ids){
        StatusData data = new StatusData();
        return listService.updateStatus(ids,1);
    }

    //下架商品
    @RequestMapping("/rest/item/instock")
    @ResponseBody
    public StatusData inStock( String ids){
        StatusData data = new StatusData();
        return listService.updateStatus(ids,2);
    }
}
