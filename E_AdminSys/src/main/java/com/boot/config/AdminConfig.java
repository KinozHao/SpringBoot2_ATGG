package com.boot.config;

import com.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kinoz
 * @Date 2023/2/23 16:00
 * @apiNote
 */
@Configuration
public class AdminConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration loginInter = registry.addInterceptor(new LoginInterceptor());
        //拦截所有路径包括静态资源
        loginInter.addPathPatterns("/**");
        //放行的路劲
        loginInter.excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");

    }
}
