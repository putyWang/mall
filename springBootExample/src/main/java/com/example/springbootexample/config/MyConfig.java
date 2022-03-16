package com.example.springbootexample.config;

import com.example.springbootexample.web.MyHandlerInterceptor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 创建springmvc配置文件类
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建拦截器对象
        HandlerInterceptor hai = new MyHandlerInterceptor();

        // 创建拦截路径
        String path = "/user/**";
        // 将拦截器加入到springmvc容器中
        registry.addInterceptor(hai).addPathPatterns(path).excludePathPatterns("/user/controller/MyController");
    }

}
