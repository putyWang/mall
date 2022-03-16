package com.ego.manage.controller;

import com.ego.commons.ResponseData.EasyUIDataGrid;
import com.ego.commons.ResponseData.EasyUiTree;
import com.ego.commons.ResponseData.StatusData;
import com.ego.commons.utils.CreatIdUtil;
import com.ego.commons.utils.FtpUtils;
import com.ego.domain.TbItem;
import com.ego.domain.TbItemCat;
import com.ego.domain.TbItemParam;
import com.ego.domain.TbItemParamItem;
import com.ego.manage.properties.FtpClientProperties;
import com.ego.service.ItemCatService;
import com.ego.service.ItemParamListService;
import com.ego.service.ListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ListItemController {
    @DubboReference(interfaceClass = ListService.class, version = "1.0")
    private ListService listService;

    @DubboReference(interfaceClass = ItemCatService.class, version = "1.0")
    private ItemCatService itemCatService;

    @DubboReference(interfaceClass = ItemParamListService.class, version = "1.0")
    private ItemParamListService itemParamListService;

    @Resource
    private FtpClientProperties ftpClientProperties;

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
        return listService.updateStatus(ids,3);
    }
    //上架商品
    @RequestMapping("/rest/item/reshelf")
    @ResponseBody
    public StatusData reShelf( String ids){
        return listService.updateStatus(ids,1);
    }

    //下架商品
    @RequestMapping("/rest/item/instock")
    @ResponseBody
    public StatusData inStock( String ids){
        return listService.updateStatus(ids,2);
    }
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUiTree> itemCatList(@RequestParam(defaultValue = "0") long id){
        List<EasyUiTree> easyUiTree = new ArrayList<>();
        EasyUiTree tree = new EasyUiTree();
        for (TbItemCat tbItemCat:itemCatService.showItemCat(id)) {
            tree.setId(tbItemCat.getId());
            tree.setText(tbItemCat.getName());
            tree.setState(tbItemCat.getIsParent() == 1?"closed":"open");
            easyUiTree.add(tree);
            tree = new EasyUiTree();
        }
        return easyUiTree;
    }

    @RequestMapping("/item/param/query/itemcatid/{id}")
    @ResponseBody
    public StatusData getId(@PathVariable long id){
        return itemParamListService.getStatusData(id);
    }

    @RequestMapping("/item/save")
    @ResponseBody
    public StatusData itemSave(TbItem tbItem, String desc, String itemParams){
        return listService.SaveItem(tbItem,desc,itemParams);
    }

    //查询商品规格参数
    @RequestMapping("/item/param/list")
    @ResponseBody
    public EasyUIDataGrid itemParamList(@RequestParam("page") int page ,
                               @RequestParam("rows") int rows){

        PageInfo<TbItemParam> pi = new PageInfo<>(itemParamListService.findList(page,rows));
        EasyUIDataGrid easyUIDataGrid = new EasyUIDataGrid();
        easyUIDataGrid.setRows(pi.getList());
        easyUIDataGrid.setTotal(pi.getTotal());
        return easyUIDataGrid;
    }

    //删除商品
    @RequestMapping("/item/param/delete")
    @ResponseBody
    public StatusData ParamDelete( String ids){
        StatusData data = new StatusData();
        return itemParamListService.deleteParam(ids);
    }

    //图片上传
    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map uploadImage(MultipartFile uploadFile){
        String genImageName = CreatIdUtil.getImgeId() + uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf("."));
        Map map = new HashMap<>();
        try {
            boolean result = FtpUtils.uploadFile(ftpClientProperties.getHostname(), ftpClientProperties.getPort(), ftpClientProperties.getUsername(), ftpClientProperties.getPassword(), ftpClientProperties.getBasePath(), ftpClientProperties.getFile(), genImageName, uploadFile.getInputStream());
            if(result){
                map.put("error", 0);
                map.put("url", "http://" + ftpClientProperties.getHostname() + ":80/image/" + genImageName);
            }else{
                map.put("error", 1);
                map.put("message", "图片上传失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            map.put("error", 1);
            map.put("message", "图片上传服务器出错");
        }
        return map;
    }
}
