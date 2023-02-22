package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kinoz
 * @Date 2023/2/21 21:42
 * @apiNote thymeleaf语法交互复习
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/thy")
    public String thy(Model model){
        model.addAttribute("msg","通过model获取的一个数据");
        model.addAttribute("link","www.baidu.com");
        return "thymeleafTest";
    }
}
