package com.example.server.book;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib对增强的使用
 * @Author:Dyy
 * @Description:
 * @Date: Created in 16:20 2019/1/31
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Class<?> aClass = o.getClass();
        String name = method.getName();
        long startTime = System.currentTimeMillis();

        Object invoke = methodProxy.invokeSuper(o, objects);

        long endTime = System.currentTimeMillis();

        System.out.println("--->cglib代理方法-->"+aClass.getName()+"."+name+"执行的时间是："+(endTime-startTime)+"ms");
        return invoke;
    }
}
