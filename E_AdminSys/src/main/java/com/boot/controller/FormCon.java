package com.boot.controller;

import com.boot.mapper.UserMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author kinoz
 * @Date 2023/2/23 20:30
 * @apiNote 此类目的主要用来实现用户信息上传功能
 */
@Controller
@Slf4j
public class FormCon {
    @Autowired
    UserMapper mapper;

    @GetMapping("/form_layouts")
    public String formLayouts(){
        return "/form/form_layouts";
    }

    @PostMapping("/upload")
    @SneakyThrows
    public String fileUpload(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestPart("favicon") MultipartFile favicon,
                             @RequestPart("lifePhoto") MultipartFile[] lifePhotos, Model model){
        //存储用户数据到数据库
        if(mapper.insertUser(username, password) == 1){
            log.info("user information insert success!!");
        }

        //存储头像图片信息到本地
        if (!favicon.isEmpty()){
            File touxiang = new File("E:\\图片\\JavaCache\\"+favicon.getOriginalFilename());
            favicon.transferTo(touxiang);
        }
        //存储生活照信息到本地
        if (lifePhotos.length > 0){
            for (MultipartFile lifePhoto : lifePhotos) {
                if (!lifePhoto.isEmpty()){
                    File file = new File("E:\\图片\\JavaCache\\" + lifePhoto.getOriginalFilename());
                    lifePhoto.transferTo(file);
                }
            }
            model.addAttribute("msg","上传用户信息成功!!");
        }
        return "/fileupload/upload_success";
    }
}
