package com.boot.controller;

import com.boot.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kinoz
 * @Date 2023/2/20 19:57
 * @apiNote
 */
@RestController
public class PersonController {
    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person method1(){
        return person;
    }
}
