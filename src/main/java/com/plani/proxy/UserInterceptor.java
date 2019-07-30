package com.plani.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class UserInterceptor {

    @Before(value = "execution(* com.plani.controller.*.*(..))")
    public void before(){
        System.out.println("进入方法前时间 "+LocalDateTime.now());
    }


    @Before(value = "execution(* com.plani.controller.*.*(..))")
    public void after(){
        System.out.println("进入方法后时间 "+LocalDateTime.now());
    }
}
