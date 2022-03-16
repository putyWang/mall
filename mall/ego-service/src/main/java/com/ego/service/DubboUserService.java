package com.ego.service;

import com.ego.domain.TbUser;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/8 23:16
 * @description：用户相关服务接口
 * @modified By：
 * @version: $
 */

public interface DubboUserService {

    /**
    *@Description: 获取user对象的信息
    *@Param:
    *@return:
    */
    TbUser getUser(String username, String password);
}
