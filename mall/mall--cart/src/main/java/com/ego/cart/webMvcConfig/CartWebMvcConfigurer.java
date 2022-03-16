package com.ego.cart.webMvcConfig;

import com.ego.cart.webMvcConfig.handler.LoginHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/9 15:25
 * @description：声明购物拦截器
 * @modified By：
 * @version: $
 */
@Configuration
public class CartWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        HandlerInterceptor loginHandler = new LoginHandler();
        String[] path = {"/cart/**"};
        registry.addInterceptor(loginHandler).addPathPatterns(path);
    }
}
