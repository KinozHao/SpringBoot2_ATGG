package com.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.SneakyThrows;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

/**
 * @author kinoz
 * @Date 2023/2/25 9:50
 * @apiNote 有关Druid数据库池相关的自定义配置参考Druid github
 * <a href="https://github.com/alibaba/druid/wiki">...</a>
 */
@Deprecated
//@Configuration
public class DBConfig {
    //此类阿里已为我们封装好,引入druid-starter即可,在application中配置相关参数
    /**
     * 自定义阿里的数据源
     * 使用此注解与spring.datasource下的配置进行绑定
     * 我们就不用一个一个去设置连接参数
     * @return
     */
    //@Bean
    @ConfigurationProperties("spring.datasource")
    @SneakyThrows
    public DataSource Druid(){
        DruidDataSource druidDataSource = new DruidDataSource();
        /*druidDataSource.setUrl();
        druidDataSource.setUsername();
        druidDataSource.setPassword();
        druidDataSource.setDriver();*/
        //stat开启状态监控功能,wall开启防火墙功能
        druidDataSource.setFilters("stat,wall");
        return  druidDataSource;
    }

    /**
     * 配置druid实时监控控制功能
     * @return
     */
    //Bean
    public ServletRegistrationBean druidControl(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> druidControl =
                new ServletRegistrationBean<StatViewServlet>(statViewServlet,"/druid/*");
        //设置监控页面的登录账号秘密
        druidControl.addInitParameter("loginUsername","admin");
        druidControl.addInitParameter("loginPassword","123456");
        return druidControl;
    }

    /**
     * WebStatFilter用于采集web-jdbc关联监控的数据
     * 配置druid web关联监控
     */
    //Bean
    public FilterRegistrationBean druidFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<Filter> druidFilter = new FilterRegistrationBean<>(webStatFilter);
        //设置拦截路径
        druidFilter.setUrlPatterns(List.of("/*"));
        //设置不拦截的路径
        druidFilter.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return  druidFilter;
    }

}
