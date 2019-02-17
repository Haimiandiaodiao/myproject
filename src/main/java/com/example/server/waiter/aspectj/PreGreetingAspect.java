package com.example.server.waiter.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/16 10:56 PM<br/>
 */

@Aspect
public class PreGreetingAspect {
    
    @Before("execution(* greetTo(..))")
    public void beforeGreeting(){
        System.out.println("HOW ARE YOU");
    }
}
