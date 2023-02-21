package com.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author kinoz
 * @Date 2023/2/21 21:14
 * @apiNote 用于开去矩阵变量
 */
@Configuration
public class JustConfig implements WebMvcConfigurer {

    //method 1 让配置类直接实现WebMvcConfigurer
    /*@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper data = new UrlPathHelper();
        //不移除;后面的内容,此时矩阵变量生效
        data.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(data);
    }*/

    //method 2 使用注册Bean组件的方式实现
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper data = new UrlPathHelper();
                data.setRemoveSemicolonContent(false);
                WebMvcConfigurer.super.configurePathMatch(configurer);
                configurer.setUrlPathHelper(data);
            }
        };
    }
}
