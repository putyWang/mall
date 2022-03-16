package com.ego.item.serviceImpl;

import com.ego.commons.utils.JsonUtils;
import com.ego.domain.TbItem;
import com.ego.item.service.ItemService;
import com.ego.service.DubboRedisManageService;
import com.ego.service.ListService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @DubboReference(interfaceClass = ListService.class, version = "1.0")
    private ListService listService;

    @DubboReference(interfaceClass = DubboRedisManageService.class, version = "1.0")
    private DubboRedisManageService dubboRedisManageServiceImpl;

    @Value("${redis.item.key}")
    private String itemKey;

    @Value("${redis.itemDesc.key}")
    private String itemDescKey;

    @Override
    public TbItem showItem(long id) {
        String key = itemKey + ":" + id;
        if(dubboRedisManageServiceImpl.redisExist(key)){
            return dubboRedisManageServiceImpl.redisGetTbItemByKey(key);
        }
        TbItem item = listService.findTbItemById(id);
        item.setImages(item.getImage() == null||item.getImage().equals("")? new String[1]:item.getImage().split(","));
        dubboRedisManageServiceImpl.redisSetTbContent(key, JsonUtils.objectToJson(item));
        return item;
    }

    @Override
    public String showItemDesc(long itemId) {
        String key = itemDescKey + ":" + itemId;
        if(dubboRedisManageServiceImpl.redisExist(key)){
            return dubboRedisManageServiceImpl.redisGetTbItemDescByKey(key);
        }
        String itemDesc = listService.findTbItemDescById(itemId).getItemDesc();
        dubboRedisManageServiceImpl.redisSetTbContent(key,itemDesc);
        return itemDesc;
    }
}
