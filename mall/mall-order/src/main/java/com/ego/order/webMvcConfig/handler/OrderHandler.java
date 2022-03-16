package com.ego.order.webMvcConfig.handler;

import com.ego.commons.ResponseData.StatusData;
import com.ego.commons.utils.CookieUtils;
import com.ego.commons.utils.HttpClientUtils;
import com.ego.commons.utils.JsonUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/9 15:28
 * @description：登录拦截器
 * @modified By：
 * @version: $
 */
public class OrderHandler implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        String userKey = CookieUtils.getCookieValue(request, "TT_TOKEN");
        //手动注入httpClientUtils
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        HttpClientUtils httpClientUtils = factory.getBean(HttpClientUtils.class);
        if(null != userKey && userKey != "" ){
            String loginUrl = "http://passport.ego.com/user/token/" + userKey;
            String body = httpClientUtils.doPost(loginUrl).getBody();
            StatusData statusData = JsonUtils.jsonToPojo(body, StatusData.class);
            if(statusData.getStatus() == 200)
                return true;
        }
        response.sendRedirect("http://passport.ego.com/user/showLogin");
        return false;
    }
}
