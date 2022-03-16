package com.ego.item;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MallItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallItemApplication.class, args);
    }

}
