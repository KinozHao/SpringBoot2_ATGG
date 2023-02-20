package com.dj.boot.controller;

import com.dj.boot.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author kinoz
 * @Date 2023/2/20 10:51
 * @apiNote
 */
@RestController
public class CarController {
    //自动注入
    @Autowired
    Car car;

    @RequestMapping(value = "/car")
    public Car method(){
        return car;
    }
}
