package com.boot.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kinoz
 * @Date 2023/2/24 15:32
 * @apiNote 使用注册组件方式时@WebServlet不写
 */
//WebServlet(urlPatterns = "/magic")
public class MyServlet extends HttpServlet {
    //使用原生的servlet向客户端发送一条信息
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello Spring");
    }
}
