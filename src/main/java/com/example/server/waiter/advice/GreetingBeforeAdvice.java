package com.example.server.waiter.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 增强打招呼之前的的增强
 * @Author:Dyy
 * @Description:
 * @Date: Created in 17:27 2019/1/31
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName =(String) objects[0];
        System.out.println("你好么？ "+clientName+"先生");
    }
}
