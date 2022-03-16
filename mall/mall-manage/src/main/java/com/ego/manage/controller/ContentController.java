package com.ego.manage.controller;

import com.ego.commons.ResponseData.EasyUIDataGrid;
import com.ego.commons.ResponseData.EasyUiTree;
import com.ego.commons.ResponseData.StatusData;
import com.ego.domain.TbContent;
import com.ego.domain.TbContentCategory;
import com.ego.manage.service.ContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ContentController {

    @Resource
    private ContentService contentServiceImpl;

    @RequestMapping("/content/category/list")
    public List<EasyUiTree> contentCategoryList(@RequestParam(defaultValue = "0") Long id){
        return contentServiceImpl.showContentCategory(id);
    }

    @RequestMapping("/content/category/create")
    public StatusData contentCategoryCreate(TbContentCategory tbContentCategory){
        return contentServiceImpl.createContentCategory(tbContentCategory);

    }

    @RequestMapping("/content/category/update")
    public StatusData contentCategoryUpdate(TbContentCategory tbContentCategory){
        return contentServiceImpl.updateContentCategory(tbContentCategory);
    }

    @RequestMapping("/content/category/delete")
    public StatusData contentCategoryDelete(long id){
        return contentServiceImpl.deleteContentCategory(id);
    }

    @RequestMapping("/content/query/list")
    public EasyUIDataGrid contentQueryList(long categoryId, int page, int rows){
        return contentServiceImpl.contentQueryList(categoryId, page, rows);
    }

    @RequestMapping("/content/save")
    public StatusData contentSave(TbContent tbContent){
        return contentServiceImpl.contentSave(tbContent);
    }

    @RequestMapping("/rest/content/edit")
    public StatusData contentEdit(TbContent tbContent){
        return contentServiceImpl.contentUpdate(tbContent);
    }
}
