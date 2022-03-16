package com.ego.search.controller;

import com.ego.commons.utils.JsonUtils;
import com.ego.domain.TbItem;
import com.ego.search.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class SearchController {

    @Resource
    private SearchService searchServiceImpl;

    @RequestMapping(value = "/solr/init", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String init(){
        Long start = System.currentTimeMillis();
        try {
            searchServiceImpl.init();
            Long end = System.currentTimeMillis() - start;
            return "初始化时长为：" + end;
        } catch (Exception e) {
            e.printStackTrace();
            return "初始化失败";
        }
    }

    /*
    * 实现搜索功能
    * */
    @RequestMapping("/search.html")
    public String SearchItem(Model model, @RequestParam String q, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "12") int rows){
        try {
            //查询结果
            Map<String, Object> stringObjectMap = searchServiceImpl.searchItem(q, page, rows);

            //添加数据到作用域之中
            model.addAttribute("query", q);
            model.addAttribute("itemList", stringObjectMap.get("list"));
            model.addAttribute("totalPages", stringObjectMap.get("totalPages"));
            model.addAttribute("page", page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "search";
    }

    //增加检索数据
    @RequestMapping(value="/add")
    @ResponseBody
    public int addItem(@RequestParam String tbItem, @RequestParam() String desc, @RequestParam String tbItemCatName){
        try {
            TbItem TbItemResponse = JsonUtils.jsonToPojo(tbItem, TbItem.class);
            searchServiceImpl.add(TbItemResponse, desc, tbItemCatName);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
    *@Description: 删除solr中的数据
    *@Param:
    *@return:
    */
    @RequestMapping(value="/delete")
    @ResponseBody
    public int delItem(@RequestParam String tbItemId){
        try {
            searchServiceImpl.deleteItem(Long.valueOf(tbItemId));
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
