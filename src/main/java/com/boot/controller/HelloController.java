package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kinoz
 * @Date 2023/2/16 20:33
 * @apiNote
 */
@RestController //此注解相当于@Controller和ResponseBody的结合 直接把映射数据传到页面
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot2";
    }
}
