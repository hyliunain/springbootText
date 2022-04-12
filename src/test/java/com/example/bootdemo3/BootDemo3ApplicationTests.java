package com.example.bootdemo3;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
class BootDemo3ApplicationTests {
    //数据源组件
    @Autowired
    DataSource dataSource;
    //用于访问数据库的组件
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        System.out.println("默认数据源为：" + dataSource.getClass());
        try {
            System.out.println("数据库连接实例：" + dataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //访问数据库
        Integer i = jdbcTemplate.queryForObject("SELECT count(*) from `hy1`", Integer.class);
        System.out.println("user 表中共有" + i + "条数据。");
    }

}
