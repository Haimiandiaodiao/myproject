package com.example.server.waiter.pointcut;

import com.example.server.waiter.PointcutWaiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/16 8:42 PM<br/>
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

    private static List<String> specialClientList = new ArrayList<String>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }
    /**
     * 对类进行静态切点检测
     * <br/>
     * @author Dyy <br/>
     * @description <br/>
     * @date 2019/2/16 8:45 PM <br/>
     */
    @Override
    public ClassFilter getClassFilter() {
        return  new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                System.out.println("调用getClassFilter()对"+aClass.getName()+"做静态检测.");
                return PointcutWaiter.class.isAssignableFrom(aClass);
            }
        };
    }

    /**
     * 对方法进行静态切点检测的
     * <br/>
     * @author Dyy <br/>
     * @description <br/>
     * @date 2019/2/16 8:44 PM <br/>
     * @param method<br/>
     * @param targetClass <br/>
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("调用matches(method,clazz)"+targetClass.getName()+"."+method.getName()+"做静态态检测.");
        return PointcutWaiter.class.isAssignableFrom(targetClass);
        
    }

    /**
     * 对方法进行动态切点检测的
     * <br/>
     * @author Dyy <br/>
     * @description <br/>
     * @date 2019/2/16 8:44 PM <br/>
     * @param method<br/>
     * @param aClass<br/>
     * @param objects <br/>
     */
    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("调用matches(method,clazz)"+aClass.getName()+"."+method.getName()+"做动态检测.");
        String clientName = (String)objects[0];
        return specialClientList.contains(clientName);
    }
}
