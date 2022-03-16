package com.ego.login.Service;

import com.ego.commons.ResponseData.StatusData;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description：获取用户登录信息接口
 * @modified By：
 * @version: $
 */
public interface LoginService {

    StatusData getUser(String username, String password, HttpServletRequest request, HttpServletResponse response);

    /**
    *@Description: 根据token查询用户信息
    *@Param:
    *@return:
    */
    StatusData getUserMsg(String token);

    /**
    *@Description: 退出登录接口
    *@Param:
    *@return:
    */
    StatusData quitLogin(String token, HttpServletRequest request, HttpServletResponse response);
}
