package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.StudentServiceImpl;

public class Test01 {
    @Test
    public void sqlTest(){
        String config = "applicationContext.xml";

        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        StudentServiceImpl studentService = (StudentServiceImpl) ac.getBean("studentService");

        System.out.println(studentService);
    }
}
