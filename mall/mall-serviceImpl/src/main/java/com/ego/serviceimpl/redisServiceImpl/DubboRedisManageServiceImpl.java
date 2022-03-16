package com.ego.serviceimpl.redisServiceImpl;

import com.ego.commons.utils.JsonUtils;
import com.ego.domain.TbItem;
import com.ego.redis.redisManage.TbContentRedis;
import com.ego.service.DubboRedisManageService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService(interfaceClass = DubboRedisManageService.class, version = "1.0", timeout = 5000)
public class DubboRedisManageServiceImpl implements DubboRedisManageService {

    @Resource
    private TbContentRedis tbContentRedisImpl;

    @Override
    public boolean redisExist(String key) {
        return tbContentRedisImpl.ExistKey(key);
    }

    @Override
    public String redisGetTbContentByKey(String key) {
        return tbContentRedisImpl.getValueByKey(key);
    }

    @Override
    public void redisSetTbContent(String key, String jsonTbContent) {
        tbContentRedisImpl.setValue(key, jsonTbContent);
    }

    @Override
    public boolean redisDelete(String key) {
        return tbContentRedisImpl.delValueByKey(key);
    }

    @Override
    public TbItem redisGetTbItemByKey(String id) {
        return JsonUtils.jsonToPojo(tbContentRedisImpl.getValueByKey(id), TbItem.class);
    }

    @Override
    public String redisGetTbItemDescByKey(String id) {
        return tbContentRedisImpl.getValueByKey(id);
    }

    /**
    *@Description: 设置过期时间
    *@Param:
    *@return:
    */
    @Override
    public void redisSetTimeOut(String key, String value, long time) {
        tbContentRedisImpl.setTimeOut(key, value, time);
    }


}
