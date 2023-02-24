package com.boot.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author kinoz
 * @Date 2023/2/24 20:18
 * @apiNote 通过注册Bean的方式实现 servlet filter listener
 */
@Configuration(proxyBeanMethods = true)//保证组件为单实例
public class MyRegisConfig {

    @Bean
    public ServletRegistrationBean<MyServlet> myServlet(){
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean<>(myServlet, "/servlet", "/servletBackup");
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilter(){
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean<MyFilter> filterBean = new FilterRegistrationBean<>(myFilter);
        //添加过滤器屏蔽掉的路径,如下路径访问就会报错
        filterBean.setUrlPatterns(Arrays.asList("/servlet","/filter/*"));
        return filterBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> myListener(){
        MyListener myListener = new MyListener();
        ServletListenerRegistrationBean<MyListener> listenerBean = new ServletListenerRegistrationBean<>(myListener);
        return listenerBean;
    }
}
