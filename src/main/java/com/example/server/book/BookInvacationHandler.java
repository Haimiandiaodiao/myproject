package com.example.server.book;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 监视BookServer类中所有方法的执行时间的监听器
 * @Author:Dyy
 * @Description:
 * @Date: Created in 15:34 2019/1/31
 */
@Data
@AllArgsConstructor
public class BookInvacationHandler implements InvocationHandler {
    private BookService bookService;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<? extends BookService> aClass = bookService.getClass();
        String name = method.getName();
        long startTime = System.currentTimeMillis();

        Object invoke = method.invoke(bookService, args);

        long endTIme = System.currentTimeMillis();

        System.out.println("--->方法-->"+aClass.getName()+"."+name+"执行的时间是："+(endTIme-startTime)+"ms");
        return invoke;
    }
}
