package com.ego.redis.redisManage;

public interface TbContentRedis {
    String getValueByKey(String key);

    void setValue(String key, String BigPic);

    boolean delValueByKey(String Key);

    boolean ExistKey(String Key);

    /**
    *@Description: 设置过期时间
    *@Param:
    *@return:
    */
    void setTimeOut(String key, String user, long time);
}
