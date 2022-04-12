package com.example.bootdemo3.controller;

import com.example.bootdemo3.bean.MyException;
import com.example.bootdemo3.bean.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(UnsatisfiedLinkError.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //向request对象传入错误状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        //根据当前处理的异常，自定义的错误数据
        map.put("code","user.notexist");
        //e.getMessage
        map.put("message",e.getMessage());
        //将自定的错误传入request域中
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
