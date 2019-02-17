package com.example.server.waiter.aspectj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/17 10:56 AM<br/>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedTest {
    boolean value() default true;
}
