package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect {

    //@Pointcut("execution(* com.*.service.impl.DeptService.*(*))")
    //@Pointcut("execution(* com.itheima.service.DeptService.*(..))")
    /*@Pointcut("execution(* com.itheima.service.DeptService.list())  ||" +
            "execution(* com.itheima.service.DeptService.delete(*))")*/
    @Pointcut("@annotation(com.itheima.aop.MyLog)")     //匹配带有@MyLog注解的方法
    private void pt(){}

    @Before("pt()")
    public void before(){
        log.info("before...");
    }
}
