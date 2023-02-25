package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kinoz
 * @Date 2023/2/25 10:08
 * @apiNote
 */
@Controller
public class DBCon {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    @ResponseBody
    public String query(){
        String sql = "select count(*) from user_crud;";
        Long num = jdbcTemplate.queryForObject(sql, Long.class);
        assert num != null;
        return "query success count: "+ num;
    }
}
