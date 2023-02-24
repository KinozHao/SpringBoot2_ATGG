package com.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.boot.mapper")
@ServletComponentScan("com.boot.servlet")
public class EAdminSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(EAdminSysApplication.class, args);
    }

}
