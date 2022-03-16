package com.ego.portal.service.impl;

import com.ego.commons.utils.JsonUtils;
import com.ego.domain.TbContent;
import com.ego.portal.service.TbContentService;
import com.ego.service.DubboContentService;
import com.ego.service.DubboRedisManageService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbContentServiceImpl implements TbContentService {
    @DubboReference(interfaceClass = DubboContentService.class, version = "1.0")
    private DubboContentService dubboContentService;

    @DubboReference(interfaceClass =  DubboRedisManageService.class, version = "1.0")
    private DubboRedisManageService redisManageService;

    @Value("${redis.bigPic.key}")
    private String bigPicKey;

    @Override
    public String showBigPic() {
        if(redisManageService.redisExist(bigPicKey))
            return redisManageService.redisGetTbContentByKey(bigPicKey);
        List<TbContent> tbContents = dubboContentService.showTbCotentByCount(6, true);
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> map;
        for (TbContent tb : tbContents) {
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

        String jsonResult = JsonUtils.objectToJson(list);
        redisManageService.redisSetTbContent(bigPicKey, jsonResult);
        return jsonResult;
    }
}
