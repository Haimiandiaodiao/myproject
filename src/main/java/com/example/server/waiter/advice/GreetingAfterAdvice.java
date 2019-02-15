package com.example.server.waiter.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置争强
 * @Author:Dyy
 * @Description:
 * @Date: Created in 18:08 2019/1/31
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("请慢用");
    }
}
