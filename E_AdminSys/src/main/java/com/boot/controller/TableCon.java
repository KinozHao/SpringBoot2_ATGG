package com.boot.controller;

import com.boot.mapper.UserMapper;
import com.boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author kinoz
 * @Date 2023/2/22 14:20
 * @apiNote thymeleaf遍历数据通过model在前端进行展示
 */
@Controller
public class TableCon {

    @Autowired
    UserMapper mapper;

    @GetMapping("/basic_table")
    public String basic_table(){
        return "/table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //获取数据库中所有用户
        List<User> users = mapper.selectList(null);
        //把获取的的对象存放在session域中
        model.addAttribute("users",users);
        return "/table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "/table/editable_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "/table/responsive_table";
    }
}
