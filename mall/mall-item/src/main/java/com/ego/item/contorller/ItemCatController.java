package com.ego.item.contorller;

import com.alibaba.fastjson.JSON;
import com.ego.domain.TbItem;
import com.ego.item.service.ItemPortalCatService;
import com.ego.item.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class ItemCatController {

    @Resource
    private ItemPortalCatService itemPortCatServiceImpl;

    @Resource
    private ItemService itemService;

    /*
    * 返回jasonp数组格式，包含所有菜单信息；
    * */
    @RequestMapping("/rest/itemcat/all")
    @ResponseBody
    public String restItemCatAll(String callback){
        String result = JSON.toJSONString(itemPortCatServiceImpl.showCatMenu());
        return callback + "(" + result + ")";
    }

    @RequestMapping("item/{itemId}.html")
    public String itemDetails(Model model, @PathVariable("itemId") long itemId){
        TbItem tbItem = itemService.showItem(itemId);
        model.addAttribute("item",tbItem);
        return "item";
    }

    @RequestMapping("/item/desc/{itemId}.html")
    @ResponseBody
    public String itemDesc(Model model, @PathVariable("itemId") long itemId){
        return itemService.showItemDesc(itemId);
    }
}
