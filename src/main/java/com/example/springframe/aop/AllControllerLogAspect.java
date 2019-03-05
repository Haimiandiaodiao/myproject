package com.example.springframe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 给所有的controller添加运行时间的增
 * @Author:Dyy
 * @Description:
 * @Date: Created in 15:19 2019/3/1
 */
@Aspect
@Component
public class AllControllerLogAspect {


    /**
     * 增强了BootStrap下的所有请求的接口
     * @Author:Dyy
     * @Description:
     * @Date: Created in 16:17 2019/3/1
     * @param proceedingJoinPoint
     */
    @Around("PointCutDeclared.bootStrapControllerAspect()")
    public Object logRunTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法简介
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodImpl = (MethodSignature)signature;
        Method method = methodImpl.getMethod();
        Class<? extends MethodSignature> aClass = methodImpl.getClass();
        String path = null;
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if(annotation instanceof PostMapping){
                PostMapping annotation1 = (PostMapping) annotation;
                String[] value = annotation1.value();
                path = Arrays.toString(value);
            }
            if(annotation instanceof GetMapping){
                String[] value = ((GetMapping) annotation).value();
                path = Arrays.toString(value);
            }
        }
        System.out.println("===调用的类名是:"+proceedingJoinPoint.getTarget().getClass().getName());
        System.out.println("===调用的方法名是："+methodImpl.getName());
        System.out.println("===请求的方法路径是："+path);


        ///==================================
        long startTime = System.nanoTime();
        System.out.println("----------->Controller的环绕增强<---------开始时间:"+startTime);
        Object proceed = proceedingJoinPoint.proceed();

        long endTime = System.nanoTime();

        System.out.println("----------->Controller的环绕增强<---------结束时间:"+endTime);
        System.out.println("----------->总共的方法用时<-------"+(endTime-startTime)+"纳秒");
        return proceed;
    }
}
