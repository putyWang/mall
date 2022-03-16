package com.ego.item.serviceImpl;

import com.ego.commons.ResponseData.portal.PortalMenu;
import com.ego.commons.ResponseData.portal.PortalMenuNode;
import com.ego.domain.TbItemCat;
import com.ego.item.service.ItemPortalCatService;
import com.ego.service.ItemCatService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemPortalCatServiceImpl implements ItemPortalCatService {

    @DubboReference(interfaceClass = com.ego.service.ItemCatService.class, version = "1.0", timeout = 5000)
    private ItemCatService itemCatService;

    @Override
    public PortalMenu showCatMenu() {
        PortalMenu portalMenu = new PortalMenu();

        //查询所有的一级菜单
        List<TbItemCat> list = itemCatService.showItemCat(0);

        portalMenu.setData(NodeOperation(list));

        return portalMenu;
    }

    List<Object> NodeOperation(List<TbItemCat> list){
        List<Object> result = new ArrayList<>();
        PortalMenuNode node;
        for (TbItemCat tb : list){
            node = new PortalMenuNode();
                //若为父菜单执行uni
                if(tb.getIsParent() == 1) {
                    node.setU("/products/" + tb.getId() + ".html");
                    node.setN("<a href='/products/" + tb.getId() + ".html'>" + tb.getName() + "</a>");
                    node.setI(NodeOperation(itemCatService.showItemCat(tb.getId())));
                    result.add(node);
                }else{
                    //若为子菜单，加入一行语句
                    result.add("/products/" + tb.getId() + ".html|" + tb.getName());
                }
            }
        return result;
    }
}
