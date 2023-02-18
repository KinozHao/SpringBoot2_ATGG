package com.dj.boot;

import com.dj.boot.config.Kconfig;
import com.dj.boot.pojo.Collage;
import com.dj.boot.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

//括号中更改了组件扫描路径,在com包下的Controller也可被识别
@SpringBootApplication(scanBasePackages = "com.dj")
public class SpringBoot2Application {

    public static void main(String[] args) {
        //1.返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot2Application.class, args);

        //2.获取所有组件名称
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(Arrays.toString(beanDefinitionNames));
        }
        //3.获取所有组件数量
        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println("ALL BEANS NUM:"+beanDefinitionCount+" PCS");

        //4.获取自定义组件的实例
        User tbUser = run.getBean("taobaowang.tbUser", User.class);
        System.out.println("自定义组件的实例:"+tbUser);

        //配置类也是一个组件的认证
        Kconfig kconfig = run.getBean(Kconfig.class);
        System.out.println(kconfig);
        //验证配置类代理Bean方法(代理模式体现,最总Bean方法两个对象为一个实例)
        User user = kconfig.tbUser();
        User user2 = kconfig.tbUser();
        System.out.println(user==user2?"true!!!":"false!!!");

        //验证Full模式
        User user3 = run.getBean("taobaowang.tbUser", User.class);
        Collage collage = run.getBean("taobaowang.tbCollage", Collage.class);
        System.out.println(user3.getCollage() == collage ? "核验正确" : "数据错误");

    }

}
