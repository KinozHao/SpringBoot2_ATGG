package com.boot;

import com.boot.pojo.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CYamlApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CYamlApplication.class, args);
        //测试我们使用yaml给Person组件注入的属性
        Person person = run.getBean("person", Person.class);
        System.out.println(person);
    }

}
