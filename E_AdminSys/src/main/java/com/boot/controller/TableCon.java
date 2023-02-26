package com.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.mapper.UserMapper;
import com.boot.pojo.User;
import com.boot.service.UserService;
import com.boot.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author kinoz
 * @Date 2023/2/22 14:20
 * @apiNote 此类目的主要用来实现后端数据在前端的展示
 * thymeleaf遍历数据通过model在前端进行展示
 */
@Controller
public class TableCon {

    @Autowired
    UserMapper UserMapper;
    @Autowired
    UserServiceImp userService;


    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){

        /**
         * @deprecated
            使用分页功能 注释代码过时
            获取数据库中所有用户
            List<User> users = userService.list();
            把数据模型通过model封装
            model.addAttribute("users",users);
         */

        //分页查询数据,每页显示两条数据
        Page<User> userPage = new Page<>(pn, 2);
        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        //当前页
        long current = page.getCurrent();
        //多少页
        long pages = page.getPages();
        //多少条记录数
        long total = page.getTotal();
        //所有用户信息
        List<User> records = page.getRecords();
        model.addAttribute("page",page);

        //给model指定展示的路径
        return "/table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String delUser(@PathVariable("id")Long id,
                          @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                          RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";

    }

    @GetMapping("/basic_table")
    public String basic_table(){
        //手动制造异常,测试500错误页面
        //int i  = 10/0;
        return "/table/basic_table";
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
