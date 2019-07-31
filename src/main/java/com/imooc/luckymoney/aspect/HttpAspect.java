package com.imooc.luckymoney.aspect;

import com.imooc.luckymoney.domain.entity.UserVo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: cedar
 * @Date: 2019/7/29 20:48
 * @Description:
 */
@Aspect
@Component
public class HttpAspect {

     public final  static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.luckymoney.controller.UserController.*(..))")
    public void log(){
        logger.info("**********************AOP日志环绕记录*************************");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("**********************AOP日志前置记录*************************");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //url
        logger.info("URL==>:{}",request.getRequestURL());

        //method
        logger.info("METHOD==>:{}",request.getMethod());

        //ip
        logger.info("IP==>:{}",request.getRemoteAddr());

        //class-name
        logger.info("CLASS-NAME==>{}:",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //params
        logger.info("args==>:{}",joinPoint.getArgs());



    }


    @After("log()")
    public void doAfter(){
        logger.info("**********************AOP日志后置记录*************************");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
         logger.info("response==>:{}",object.toString());
    }


}
