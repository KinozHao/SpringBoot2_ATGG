package com.boot.controller;

import com.boot.entity.Car;
import com.boot.mapper.CarMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author kinoz
 * @Date 2023/2/25 17:20
 * @apiNote
 */
@Controller
@Slf4j
public class DbCon {
    @Resource
    CarMapper carMapper;

    @GetMapping("/car_info")
    @ResponseBody
    public Car carInfo(@RequestParam("id")Integer id){
        Car car = carMapper.CarInfoById(id);
        return car;
    }

    @RequestMapping(value = {"/","/index"})
    public String indexPage(){
        return "index";
    }

    @PostMapping(value = "/insertCar" )
    public String insetCar(@RequestParam Integer id,
                           @RequestParam String brand,
                           @RequestParam String country,
                           Model model){
        int i = carMapper.insertCarInfo(id, brand, country);
        if (i == 1){
            model.addAttribute("msg","插入用户信息成功");
        }else {
            model.addAttribute("msg","存在重复id无法添加");
        }
        return "/insert/success";
    }
}
