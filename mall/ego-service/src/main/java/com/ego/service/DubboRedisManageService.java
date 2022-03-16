package com.ego.service;

import com.ego.domain.TbItem;

public interface DubboRedisManageService {

    boolean redisExist(String key);

    String redisGetTbContentByKey(String key);

    void redisSetTbContent(String key, String jsonTbContent);

    boolean redisDelete(String key);

    TbItem redisGetTbItemByKey(String id);

    String redisGetTbItemDescByKey(String id);

    void redisSetTimeOut(String key, String value, long time);
}
