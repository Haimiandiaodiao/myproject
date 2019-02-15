package com.example.server.waiter.advice;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 19:17 2019/1/31
 */
public class GreetingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        //1.目标方法入参
        Object[] args = methodInvocation.getArguments();
        String clientName =(String) args[0];
        System.out.println("你好么？"+clientName+"先生");

        Object proceed = methodInvocation.proceed();

        System.out.println("请享受你的饭");

        return proceed;
    }
}
