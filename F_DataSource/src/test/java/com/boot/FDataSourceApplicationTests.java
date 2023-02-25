package com.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.JDBCType;
import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
@Slf4j
class FDataSourceApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        String sql = "select  count(*) from user_crud;";
        Long num = jdbcTemplate.queryForObject(sql, Long.class);

        log.info("table中总共几条记录数:"+num);
        log.info("Database pool type:"+dataSource.getClass());

    }

}
