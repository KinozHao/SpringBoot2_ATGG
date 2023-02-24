package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kinoz
 * @Date 2023/2/24 21:49
 * @apiNote
 */
@Controller
public class ExtraCon {

    @RequestMapping("/profile")
    public String profile(){

        return "/extra/profile";
    }
}
