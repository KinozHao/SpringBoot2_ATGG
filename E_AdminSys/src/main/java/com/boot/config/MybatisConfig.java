package com.boot.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kinoz
 * @Date 2023/2/26 19:39
 * @apiNote
 */
@Configuration
public class MybatisConfig {

    //分页插件
    @Bean
    public MybatisPlusInterceptor pageMethod(){
        MybatisPlusInterceptor tool = new MybatisPlusInterceptor();
        PaginationInnerInterceptor pii = new PaginationInnerInterceptor();
        //请求页面大于最大页面后操作 true调回首页 false继续请求
        pii.setOverflow(true);
        //最大页显示设置
        pii.setMaxLimit(500L);
        tool.addInnerInterceptor(pii);
        return tool;
    }
}
