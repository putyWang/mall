package com.ego.login.controller;

import com.alibaba.fastjson.JSON;
import com.ego.login.Service.LoginService;
import com.ego.commons.ResponseData.StatusData;
import org.apache.http.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description：视图控制器
 * @modified By：
 * @version: $
 */
@Controller
public class JspController {

    @Resource
    private LoginService loginServiceImpl;
    /**
    *@Description: 转到登录页面
    *@Param:
    *@return:
    */
    @RequestMapping("/user/showLogin")
    public String showLogin(@RequestHeader("Referer") String url, Model model){
        model.addAttribute("redirect", url);
        return "login";
    }

    @RequestMapping("/user/login")
    @ResponseBody
    public StatusData login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response){
        StatusData data = loginServiceImpl.getUser(username, password, request, response);
        return data;
    }

    /**
    *@Description: 通过token获取用户信息
    *@Param: 
    *@return: 
    */
    @RequestMapping("/user/token/{token}")
    @ResponseBody
    public Object getUserMsg(@PathVariable String token, String callback){
        StatusData data = loginServiceImpl.getUserMsg(token);
        if(callback != null && !callback.equals("")){
            String result = JSON.toJSONString(data);
            return callback + "(" + result + ")";
        }
        return data;
    }

    /**
    *@Description: 用户退出登录
    *@Param: 
    *@return: 
    */
    @RequestMapping("/user/logout/{token}")
    @ResponseBody
    public Object quitLogin(@PathVariable String token, String callback, HttpServletRequest request, HttpServletResponse response) {
        StatusData data = loginServiceImpl.quitLogin(token, request, response);
        if (callback != null && !callback.equals("")) {
            String result = JSON.toJSONString(data);
            return callback + "(" + result + ")";
        }
        return data;
    }
}
