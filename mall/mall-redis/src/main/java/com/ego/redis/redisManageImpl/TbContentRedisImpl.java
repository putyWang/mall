package com.ego.redis.redisManageImpl;

import com.ego.redis.redisManage.TbContentRedis;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository
public class TbContentRedisImpl implements TbContentRedis {
    //自动注入redisTemplate
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    //通过url获取TbContent
    @Override
    public String getValueByKey(String key) {
        //开启redisTemplate连接
        ValueOperations<String, Object> valueOperations = this.getValueOperations();
        if(null != valueOperations.get(key))
            return (String)valueOperations.get(key);
        else
            return null;
    }

    //添加TbContent
    @Override
    public void setValue(String key, String BigPic) {
        ValueOperations<String, Object> valueOperations = this.getValueOperations();
        valueOperations.set(key, BigPic);
    }

    //通过url删除TbContent
    @Override
    public boolean delValueByKey(String url) {
        return redisTemplate.delete(url);
    }

    //判断数据库中是否存在某个key
    @Override
    public boolean ExistKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
    *@Description: 设置键值过期时间
    *@Param:
    *@return:
    */
    @Override
    public void setTimeOut(String key, String user, long time) {
        ValueOperations<String, Object> valueOperations = this.getValueOperations();
        valueOperations.set(key, user, time, TimeUnit.SECONDS);
    }

    public ValueOperations<String, Object> getValueOperations(){
        return redisTemplate.opsForValue();
    }
}
