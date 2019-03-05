package com.example.springframe.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 16:14 2019/3/1
 */

public class PointCutDeclared {
    @Pointcut("execution(* com.example.*.*(..))")
    public void bootStrapControllerAspect(){}
}
