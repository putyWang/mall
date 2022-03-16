package com.example.springbootexample.configuration;

import com.example.springbootexample.controller.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Servlet;

@Configuration
public class MyConfiguration {

    @Bean
    public FilterRegistrationBean myFilterRegistrationBean(){
        //创建FilterRegistrationBean对象
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //创建CharacterEncodingFilter对象
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        //设置编码格式为utf-8
        filter.setEncoding("utf-8");
        //更改请求编码格式
        filter.setForceRequestEncoding(true);
        //更改响应编码格式
        filter.setForceResponseEncoding(true);
        //将过滤器加入到FilterRegistrationBean对象中
        filterRegistrationBean.setFilter(filter);
        //将过滤路径加入到FilterRegistrationBean对象中
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean myServletRegistrationBean(){
        //创建CharacterEncodingFilter对象
        Servlet myServlet = new MyServlet();
        //创建ServletRegistrationBean对象
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(myServlet,"/myServlet");

        return servletRegistrationBean;
    }
}
