package com.ego.serviceimpl.userServiceImpl;

import com.ego.domain.TbUser;
import com.ego.service.DubboUserService;
import com.ego.serviceimpl.dao.TbUserMapper;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/9 9:21
 * @description：操作用户实现类
 * @modified By：
 * @version: $
 */
@DubboService(interfaceClass = DubboUserService.class, version = "1.0", timeout = 5000)
public class DubboUserServiceImpl implements DubboUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getUser(String username, String password) {
        return tbUserMapper.selectByUsernameAndPassword(username, password);
    }
}
