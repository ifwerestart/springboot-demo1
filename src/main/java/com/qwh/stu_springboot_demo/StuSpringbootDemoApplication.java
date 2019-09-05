package com.qwh.stu_springboot_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.qwh.stu_springboot_demo")
@SpringBootApplication
public class StuSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuSpringbootDemoApplication.class, args);
    }

}
