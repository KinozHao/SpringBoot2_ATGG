package com.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author kinoz
 * @Date 2023/2/22 11:08
 * @apiNote
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//指定数据库表名
@TableName("user")
public class User {
    //暂时不用标识它不存在
    @TableField(exist = false)
    private String password;
    @TableField(exist = false)
    private String username;

    private int id;
    private String name;
    private int age;
    private String email;
}
