package com.itheima.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)     //表示在运行时有效
@Target(ElementType.METHOD)         //指定当前注解可以作用在哪些地方，ElementType.METHOD表示作用在方法上
public @interface MyLog {
}
