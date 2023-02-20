package com.dj.boot.config;

import com.dj.boot.pojo.Car;
import com.dj.boot.pojo.Collage;
import com.dj.boot.pojo.User;
import com.dj.boot.pojo.ymltest.Person;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author kinoz
 * @Date 2023/2/18 23:13
 * @apiNote 此类作为一个类配置类，用于添加自定义的组件
 * 配置类本身也为一个组件
 * proxyBeanMethods 代理Bean的方法,默认true
 * Full(proxyBeanMethods=true)单实例
 * Lite(proxyBeanMethods=false)多实例
 *
 * 通过Import注解也可以向容器中添加组件,默认组件的名字就是全类名
 */
@Import({User.class, StaticLoggerBinder.class})
@Configuration(proxyBeanMethods = true)
@ImportResource("classpath:beans.xml")  //导入Spring配置文件
@EnableConfigurationProperties({Car.class})
public class Kconfig {

    //Bean注解用于标识此方法为一个组件,方法名即为组件id
    //返回的类型就是组件的类型,返回的值就是组件在容器中的实例
    //Bean注解中也可以自定义组件id
    //用Bean标签注册的组件都为单实例
    @ConditionalOnBean(name = "taobaowang.tbCollage")   //表示此组件在包含对应名称组件时才生效,否则不生效
    @Bean("taobaowang.tbUser")
    public User tbUser(){
        User Huang = new User("黄磊", 23);
        //此组件依赖了toCoolage组件
        Huang.setCollage(tbCollage());
        return Huang;
    }

    //测试condition
    //@Bean("taobaowang.tbCollage")
    public Collage tbCollage(){
        return new Collage("河海大学","南京");
    }


}
