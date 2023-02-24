package com.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author kinoz
 * @Date 2023/2/24 19:10
 * @apiNote 使用注册组件方式时@WebListener不写
 */
//@WebListener
@Slf4j
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("监听器已经启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("监听器销毁");
    }
}
