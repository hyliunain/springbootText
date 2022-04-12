package com.example.bootdemo3.controller;

import com.example.bootdemo3.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    //自动装配 jdbcTemplate
    @Autowired
    JdbcTemplate jdbcTemplate;
    /**
     * 跳转到登陆页面
     *
     * @return
     */
    @GetMapping(value = {"/login"})
    public String loginPage() {
        //跳转到登录页 login.html
        return "login";
    }
    @GetMapping(value = {"/testException"})
    public String testException(String user){
        if("user".equals(user)){
            throw new UserNotExistException();
        }
        return "login";
    }

    @ResponseBody
    @GetMapping("/testSql")
    public String testSql() {
        String SQL = "SELECT count(*) from `hy1`";
        Integer integer = jdbcTemplate.queryForObject(SQL, Integer.class);
        return integer.toString();
    }
}
