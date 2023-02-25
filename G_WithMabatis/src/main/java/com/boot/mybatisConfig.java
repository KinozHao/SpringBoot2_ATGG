package com.boot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kinoz
 * @Date 2023/2/25 16:59
 * @apiNote
 */
@SpringBootApplication
@MapperScan("com.boot.mapper")
public class mybatisConfig {
    public static void main(String[] args) {
        SpringApplication.run(mybatisConfig.class,args);
    }
}
