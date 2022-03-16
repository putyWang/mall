package com.ego.manage.serviceImpl;

import com.ego.commons.ResponseData.EasyUIDataGrid;
import com.ego.commons.ResponseData.EasyUiTree;
import com.ego.commons.ResponseData.StatusData;
import com.ego.commons.utils.CreatIdUtil;
import com.ego.commons.utils.JsonUtils;
import com.ego.domain.TbContent;
import com.ego.domain.TbContentCategory;
import com.ego.manage.service.ContentService;
import com.ego.service.DubboContentService;
import com.ego.service.DubboRedisManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {

    @DubboReference(interfaceClass = DubboContentService.class, version = "1.0")
    private DubboContentService dubboContentService;

    @DubboReference(interfaceClass = DubboRedisManageService.class, version = "1.0")
    private DubboRedisManageService dubboRedisManageService;

    @Value("${redis.bigPic.key}")
    String key;

    @Override
    public List<EasyUiTree> showContentCategory(long pid) {
        List<EasyUiTree> easyUiTree = new ArrayList<>();
        EasyUiTree tree;
        for (TbContentCategory tb:dubboContentService.showContentCategory(pid)) {
            tree = new EasyUiTree();
            tree.setId(tb.getId());
            tree.setText(tb.getName());
            tree.setState(tb.getIsParent() == 1?"closed":"open");
            easyUiTree.add(tree);
        }
        return easyUiTree;
    }

    @Override
    public StatusData createContentCategory(TbContentCategory tbContentCategory) {

        StatusData statusData = new StatusData();
        for (TbContentCategory tb:dubboContentService.showContentCategory(tbContentCategory.getParentId())){
            if(tb.getName().equals(tbContentCategory.getName()))
                return statusData;
        }
        LocalDateTime date = LocalDateTime.now();
        tbContentCategory.setUpdated(date);
        tbContentCategory.setStatus(1);
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setIsParent(0);
        Map<String, Long> map = new HashMap<>();
        int count = 0;
        long id = CreatIdUtil.getId();
        tbContentCategory.setId(id);
        tbContentCategory.setCreated(date);
        TbContentCategory parent = new TbContentCategory();
        parent.setId(tbContentCategory.getParentId());
        parent.setIsParent(1);
        map.put("id", id);
        count += dubboContentService.updateContentCategory(parent);
        count += dubboContentService.insertContentCategory(tbContentCategory);
        if(count == 2){
            statusData.setStatus(200);
            statusData.setData(map);
        }
        return statusData;
    }

    @Override
    public StatusData updateContentCategory(TbContentCategory tbContentCategory) {

        StatusData statusData = new StatusData();
        for (TbContentCategory tb:dubboContentService.showContentCategory(dubboContentService.findContentCategoryById(tbContentCategory.getId()).getParentId())){
            if(tb.getName().equals(tbContentCategory.getName()))
                return statusData;
        }
        LocalDateTime date = LocalDateTime.now();
        tbContentCategory.setUpdated(date);
        if(dubboContentService.updateContentCategory(tbContentCategory) == 1){
            statusData.setStatus(200);
        }
        return statusData;
    }

    @Override
    public StatusData deleteContentCategory(long id) {
        StatusData statusData = new StatusData();
        LocalDateTime date = LocalDateTime.now();
        int count = 0;
        long pid = dubboContentService.findContentCategoryById(id).getParentId();
        if(dubboContentService.showContentCategory(pid).size() == 1){
            count += dubboContentService.deleteContentCategory(id);
            TbContentCategory parent = new TbContentCategory();
            parent.setId(pid);
            parent.setIsParent(0);
            parent.setUpdated(date);
            count += dubboContentService.updateContentCategory(parent);
            if(count == 2)
                statusData.setStatus(200);
        }else{
            count += dubboContentService.deleteContentCategory(id);
            if (count == 1)
                statusData.setStatus(200);
        }
        return statusData;
    }

    @Override
    public EasyUIDataGrid contentQueryList(long categoryId, int page, int rows) {
        EasyUIDataGrid easyUIDataGrid = new EasyUIDataGrid();
        PageHelper.startPage(page, rows);
        PageInfo<TbContent> pi = new PageInfo<>(dubboContentService.showTbCotent(categoryId));
        easyUIDataGrid.setRows(pi.getList());
        easyUIDataGrid.setTotal(pi.getTotal());
        return easyUIDataGrid;
    }

    @Override
    public StatusData contentSave(TbContent tbContent) {
        StatusData statusData = new StatusData();
        LocalDateTime date = LocalDateTime.now();
        tbContent.setUpdated(date);
        tbContent.setCreated(date);
        if(1 == dubboContentService.saveContent(tbContent)){
            statusData.setStatus(200);
        }
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> map;
        for (TbContent tb : dubboContentService.showTbCotentByCount(6, true)) {
            map = new HashMap<>();
            map.put("srcB", tb.getPic2());
            map.put("height", 240);
            map.put("alt", "对不起，加载图片失败");
            map.put("width", 670);
            map.put("src", tb.getPic());
            map.put("widthB", 550);
            map.put("href", tb.getUrl());
            map.put("heightB", 240);

            list.add(map);
        }
        dubboRedisManageService.redisSetTbContent(key,JsonUtils.objectToJson(list));
        return statusData;
    }

    @Override
    public StatusData contentUpdate(TbContent tbContent) {
        StatusData statusData = new StatusData();
        LocalDateTime date = LocalDateTime.now();
        tbContent.setUpdated(date);
        if(1 == dubboContentService.updateContent(tbContent))
            statusData.setStatus(200);
        return statusData;

    }
}
