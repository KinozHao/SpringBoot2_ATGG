package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kinoz
 * @Date 2023/2/21 15:10
 * @apiNote
 */
@RestController
public class HelloController {

    @RequestMapping("/99.jpg")
    public String hello(){
        return "当控制器名称和静态资源下的名称一样时候，默认先访问Controller下的";
    }
}
