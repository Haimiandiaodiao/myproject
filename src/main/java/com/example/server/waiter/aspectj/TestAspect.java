package com.example.server.waiter.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/17 11:05 AM<br/>
 */
@Aspect
public class TestAspect {

    /**
     * 标注了这个注解的方法会被的添加后置增强
     * <br/>
     * @author Dyy <br/>
     * @description <br/>
     * @date 2019/2/17 11:07 AM <br/>
     */
    @AfterReturning("@annotation(com.example.server.waiter.aspectj.NeedTest)")
    public void needTestFun(){
        System.out.println("NeedTestFun() executed!");
    }
}
