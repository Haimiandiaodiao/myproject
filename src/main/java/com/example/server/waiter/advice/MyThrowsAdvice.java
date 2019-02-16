package com.example.server.waiter.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 19:25 2019/1/31
 */
public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, RuntimeException e){
            System.out.println("------------出现异常了----------");
            System.out.println("------------方法名称------------"+method.getName());
            e.printStackTrace();
    }

}
