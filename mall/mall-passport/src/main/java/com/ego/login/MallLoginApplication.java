package com.ego.login;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MallLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallLoginApplication.class, args);
    }

}
