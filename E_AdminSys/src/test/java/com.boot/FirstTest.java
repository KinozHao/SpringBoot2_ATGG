package com.boot;

import com.boot.mapper.UserMapper;
import com.boot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author kinoz
 * @Date 2023/2/26 16:02
 * @apiNote
 */
@SpringBootTest
public class FirstTest {
    @Autowired
    UserMapper mapper;

    @Test
    void test1(){
        List<User> users = mapper.selectList(null);
        users.forEach(System.out::println);
    }
}
