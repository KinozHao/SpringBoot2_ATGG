package com.boot.controller;

import com.boot.mapper.UserMapper;
import com.boot.pojo.User;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author kinoz
 * @Date 2023/2/22 10:54
 * @apiNote 此类目的主要用来实现登录认证
 */
@Controller
public class IndexCon {
    @Autowired
    UserMapper userMapper;

    @GetMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String index(@RequestParam String username,@RequestParam String password, HttpSession session, Model model) {

        //判断用户登录,防止通过路径直接进入后台(使用Mybatis-Plus)
        User loginUser = userMapper.userLogin(username, password);
        if (null != loginUser){
        //if (StringUtils.hasLength(loginUser.getUsername()) && loginUser.getPassword().equals("1")){
            session.setAttribute("loginUser",loginUser);
            return "redirect:index.html";
        }else {
            //提示错误消息
            model.addAttribute("msg","用户名密码错误!!");
            //回到登录页
            return "login";
        }
    }
    //防止重复登录,登陆后让/login重定义到index页面
    //再刷新时候就是/index.html这个路径,而不会又返回到login页面
    @GetMapping("/index.html")
    public String trueIndex(HttpSession session,Model model){
        Object loginUser = session.getAttribute("loginUser");
        //判断一下是否登录 也可使用拦截器
        if (loginUser != null){
            return "index";
        }else {
            //回到登陆页面
            model.addAttribute("msg","请重新登录!!");
            return "login";
        }
    }
}
