package com.example.server.waiter.pointcut;

import com.example.server.waiter.PointcutWaiter;
import com.example.server.waiter.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * 静态方法匹配切点切面
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/16 7:42 PM<br/>
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    /**
     * 要过滤的方法
     * <br/>
     * @author Dyy <br/>
     * @description <br/>
     * @date 2019/2/16 7:48 PM <br/>
     * @param method<br/>
     * @param aClass <br/>
     */
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "greetTo".equals(method.getName());
    }

    /**
     * 该切面匹配的类
     * 现过滤类，之后在过滤方法
     * <br/>
     * @author Dyy <br/>
     * @description <br/>
     * @date 2019/2/16 7:47 PM <br/>*
     */
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return PointcutWaiter.class.isAssignableFrom(aClass);
            }
        };
    }
}
