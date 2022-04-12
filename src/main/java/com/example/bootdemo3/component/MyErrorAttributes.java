package com.example.bootdemo3.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    public Map<String,Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options){
        Map<String,Object> errorAttributes = super.getErrorAttributes(webRequest,options);
        //添加自定义的错误数据
        errorAttributes.put("company","www.biancheng.net");
        //获取MyExceptionHandler传入request域中的错误数据
        Map ext = (Map)webRequest.getAttribute("ext",0);
        errorAttributes.put("ext",ext);
        return errorAttributes;
    }
}
