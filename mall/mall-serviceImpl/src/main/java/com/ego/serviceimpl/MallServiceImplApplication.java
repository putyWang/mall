package com.ego.serviceimpl;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubbo
@ComponentScan(basePackages = {"com.ego.redis", "com.ego.serviceimpl","com.ego.commons"})
public class MallServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceImplApplication.class, args);
    }

}
