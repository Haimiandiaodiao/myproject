package com.example.server.waiter.pointcut.advice;

import org.springframework.aop.MethodBeforeAdvice;
import sun.jvm.hotspot.oops.ObjectHeap;

import java.lang.reflect.Method;

/**
 * 这是一个给切面使用的前置增强
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/16 7:53 PM<br/>
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice
{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("-->静态切面的前置增强-->"+o.getClass().getName()+"."+method.getName());
        String clientName = (String)objects[0];
        System.out.println("-->静态切面的前置增强-->How are you! Mr."+clientName+".");
    }
}
