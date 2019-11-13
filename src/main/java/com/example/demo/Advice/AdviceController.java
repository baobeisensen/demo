package com.example.demo.Advice;
import	java.util.HashMap;

import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice(basePackages = "com.example.demo.Controller")
public class AdviceController {

    @ResponseBody//返回json格式
    @ExceptionHandler(Exception.class)
    public Map<String,Object> errorMessage() {
        Map<String,Object> errorMessages = new HashMap<String, Object> ();
        errorMessages.put("errorcode","500");
        errorMessages.put("errorMsg", "系统错误");
        return errorMessages;
    }
    @ResponseBody//返回json格式
    @ExceptionHandler(UnknownAccountException.class)
    public Map<String,Object> UnknownAccountMessage() {
        Map<String,Object> errorMessages = new HashMap<String, Object> ();
        errorMessages.put("errorcode","403");
        errorMessages.put("errorMsg", "用户名或密码错误!");
        return errorMessages;
    }

}
