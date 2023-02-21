package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kinoz
 * @Date 2023/2/21 18:58
 * @apiNote MVC请求响应复习
 */
@RestController
public class ParamController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,    //传递参数
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent, //传递请求头信息
                                      @RequestHeader Map<String, String> header) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", name);
        return map;
    }

    @GetMapping("/headers")
    public List<Object> getHeaders(@RequestHeader("User-Agent") String userAgent, //传递请求头信息
                                   @RequestHeader Map<String, String> header) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(userAgent);
        list.add(header);
        return list;
    }

    @PostMapping("/save")
    //从页面获取信息返回
    public Map<Object,Object> getInfo(@RequestBody String content){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    //矩阵变量的使用
    @RequestMapping("/cars/{path}")
    public Map<Object,Object> getMatrixVar(@MatrixVariable("low")Integer low,
                                           @MatrixVariable("brand")List<String> brand,
                                            @PathVariable("path")String path){
        HashMap<Object, Object> data = new HashMap<>();
        data.put("low",low);
        data.put("brand",brand);
        System.out.println("实际路径"+path);
        return data;
    }
}
