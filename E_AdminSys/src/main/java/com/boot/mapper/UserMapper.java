package com.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kinoz
 * @Date 2023/2/22 21:22
 * @apiNote
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from springboot.user where username = #{username} and password = #{password};")
    User userLogin(@Param("username") String username, @Param("password") String password);
}
