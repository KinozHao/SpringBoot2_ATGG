package com.dj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kinoz
 * @Date 2023/2/18 22:49
 * @apiNote 此Controller用于测试我们自己更改的路径
 */
@RestController
public class TController {
    @RequestMapping("/test")
    public String word(){
        return "外层Controller";
    }
}
