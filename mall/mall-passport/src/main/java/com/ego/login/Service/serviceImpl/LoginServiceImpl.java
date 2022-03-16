package com.ego.login.Service.serviceImpl;

import com.ego.commons.utils.CookieUtils;
import com.ego.commons.utils.JsonUtils;
import com.ego.login.Service.LoginService;
import com.ego.commons.ResponseData.StatusData;
import com.ego.domain.TbUser;
import com.ego.service.DubboRedisManageService;
import com.ego.service.DubboUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/8 23:15
 * @description：
 * @modified By：
 * @version: $
 */

@Service
public class LoginServiceImpl implements LoginService {

    @DubboReference(interfaceClass = DubboUserService.class, version = "1.0")
    private DubboUserService dubboUserService;

    @DubboReference(interfaceClass = DubboRedisManageService.class, version = "1.0")
    private DubboRedisManageService redisManageService;

    @Value("${user.key}")
    private String userKey;

    /**
    *@Description: 获取用户信息服务的实现
    *@Param: 
    *@return: 
    */
    @Override
    public StatusData getUser(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        TbUser user = dubboUserService.getUser(username, password);
        StatusData data = new StatusData();
        if(user != null){
            String Key = userKey + ":" + user.getUsername();
            //向redis中添加user信息
            int timeOut = 60*60;
            redisManageService.redisSetTimeOut(Key, JsonUtils.objectToJson(user), timeOut);
            //向cookie中添加用户信息
            //设置请求、响应、cookie名称、cookie值、过期时间
            CookieUtils.setCookie(request,response,"TT_TOKEN",Key,timeOut);
            data.setStatus(200);
        }
        else
            data.setMsg("用户名或者密码有误，登录失败");
        return data;
    }

    /**
    *@Description: 根据token查询用户信息
    *@Param: 
    *@return: 
    */
    @Override
    public StatusData getUserMsg(String token) {
        StatusData data = new StatusData();
        String userMsg = redisManageService.redisGetTbContentByKey(token);
        if(null != userMsg && !"" .equals(userMsg)){
            data.setStatus(200);
            TbUser user = JsonUtils.jsonToPojo(userMsg, TbUser.class);
            user.setPassword(null);
            data.setMsg("ok");
            data.setData(user);
        }else
            data.setMsg("用户未登录，请登录后查看");
        return data;
    }

    /**
     *@Description: 退出登录实现类
     *@Param:
     *@return:
     */
    @Override
    public StatusData quitLogin(String token, HttpServletRequest request, HttpServletResponse response) {
        StatusData data = new StatusData();
        boolean result = false;
        if(redisManageService.redisExist(token)){
           result = redisManageService.redisDelete(token);
           CookieUtils.deleteCookie(request,response,"TT_TOKEN");
        }
        if(result){
            data.setStatus(200);
            data.setMsg("ok");
        }else
            data.setMsg("退出失败");

        return data;
    }
}
