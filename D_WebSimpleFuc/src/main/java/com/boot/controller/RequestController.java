package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kinoz
 * @Date 2023/2/21 19:46
 * @apiNote RequestAttribute注解的使用
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String hello(HttpServletRequest request){
        request.setAttribute("msg","success!!");
        request.setAttribute("verifyCode","15463");
        return "forward:/success";  //转发到success
    }

    @ResponseBody
    @GetMapping("/success")
    public Map getData(@RequestAttribute("msg") String msg,
                       @RequestAttribute("verifyCode")Integer verifyCode,
                        HttpServletRequest request){
        Object msg2 = request.getAttribute("msg");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("with_annotaion",msg);
        map.put("with_Http",msg2);
        return map;
    }
}
