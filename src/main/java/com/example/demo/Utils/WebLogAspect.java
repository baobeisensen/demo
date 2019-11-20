package com.example.demo.Utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/*@Component
@Aspect
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.example.demo.Controller.*.*(..)) && !execution(public * com.example.demo.Controller.WebSocketServer.*(..))")
    public void webLog(){

    }


*//**
     * 前置通知攔截請求
     * @param joinPoint
     * @throws Throwable
     *//*

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //記錄下請求内容
        logger.info("URL="+request.getRequestURL());
        logger.info("HTTP_METHOD="+request.getMethod());
        logger.info("IP="+request.getRemoteAddr());
        Enumeration<String> enu = request.getHeaderNames();
        while (enu.hasMoreElements()){
            String name = (String)enu.nextElement();
            logger.info("name:{},value:{}",name,request.getHeader(name));
        }
    }
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("RESPONSE : "+ ret);
    }
}*/

