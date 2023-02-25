package com.boot.config;

import com.boot.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kinoz
 * @Date 2023/2/25 11:40
 * @apiNote 此配置类只是为了测试Druid的SpringBean监控
 */
@Configuration
public class BeanConfig {

    @Bean("userBean")
    public User MyUser(){
        return new User("李明","清华大学");
    }
}
