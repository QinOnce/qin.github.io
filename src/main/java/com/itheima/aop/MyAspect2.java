package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class MyAspect2 {

    @Pointcut("execution(* com.itheima.service.DeptService.*(..))")
    public void pt(){}

    @Before("pt()")
    public void before(){
        log.info("before");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around..before");

        //获取目标对象的类名
        String className = joinPoint.getTarget().getClass().getName();
        log.info("目标对象的类名:{}",className);

        //获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("目标方法的方法名:{}",methodName);

        //获取目标方法运行时传入的参数
        Object[] args = joinPoint.getArgs();
        log.info("目标方法运行时传入的参数：{}", Arrays.toString(args));

        //放行，目标方法执行
        Object result=joinPoint.proceed();

        //获取目标方法的返回值
        log.info("目标方法的返回值:{}",result);

        log.info("around...after");
        return result;
    }
}
