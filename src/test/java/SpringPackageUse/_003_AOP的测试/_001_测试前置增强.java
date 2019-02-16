package SpringPackageUse._003_AOP的测试;

import com.example.server.waiter.NaiveWaiter;
import com.example.server.waiter.Waiter;
import com.example.server.waiter.advice.*;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import sun.awt.geom.AreaOp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 17:32 2019/1/31
 */
public class _001_测试前置增强 {
    @Test
    public void 前置增强的测试(){
        NaiveWaiter target = new NaiveWaiter();
        GreetingBeforeAdvice advice = new GreetingBeforeAdvice();
        GreetingAfterAdvice greetingAfterAdvice = new GreetingAfterAdvice();
        GreetingInterceptor greetingInterceptor = new GreetingInterceptor();
        //1.spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        //2.设置代理目标
        pf.setTarget(target);
        //3.为代理目标设置增强
        pf.addAdvice(advice);
        pf.addAdvice(greetingAfterAdvice);
        pf.addAdvice(greetingInterceptor);
        pf.addAdvice(greetingInterceptor);

        //4.生成代理实例
        Waiter proxy = (Waiter)pf.getProxy();
        proxy.greetTo("Dyy");
        String dyy = proxy.serveTo("Dyy");
        System.out.println(dyy);

    }


    @Test
    public void 异常的增强() {
        MyThrowsAdvice myThrowsAdvice = new MyThrowsAdvice();
        NaiveWaiter target = new NaiveWaiter();

        ProxyFactory fac = new ProxyFactory();

        fac.setTarget(target);
        fac.addAdvice(myThrowsAdvice);
        Object proxy1 = fac.getProxy();

        NaiveWaiter proxy = (NaiveWaiter) proxy1;
        proxy.greetTo("Dyy");
        proxy.exceptionMethod();


    }

    @Test
    public void 引介增强的测试(){
        //1.spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();

        //2.实例化引介增强
        MyIntroductionInterceptor intro = new MyIntroductionInterceptor();

        //3.实例化要增强的对象
        NaiveWaiter target = new NaiveWaiter();

        pf.setTarget(target);
        pf.addAdvice(intro);
        //使用cglib来进行继承的优化也就是用来产生代理
        //!去掉这一句将会报错
        pf.setOptimize(true);

        //4.生成代理实例
        Waiter proxy = (Waiter)pf.getProxy();

        proxy.serveTo("Dyy");

        MyIntroducton1 proxy1 = (MyIntroducton1) proxy;
        proxy1.setDiyProperty("这是我自定义的属性NiuPP");
        proxy1.setIsFlag(true);

        proxy.serveTo("Dyy");

        //-----------------------探究代理对象的类结构------------------
        Class<?> clazz = proxy.getClass();
        System.out.println("1.代理对象的类名字--->" + clazz.getName());
        Class<?> superclass = clazz.getSuperclass();
        System.out.println("2.代理对象继承的父类--->" + superclass.getName());
        Class<?>[] interfaces = clazz.getInterfaces();
        Object[] objects = Arrays.stream(interfaces).map(e -> {
            int i = e.getName().lastIndexOf(".");
            return e.getName().substring(i+1);
        }).toArray();
        String join = Joiner.on(",").join(objects);
        System.out.println("3.代理对象实现的接口--->" + join);


        //查看内部的属性
       //Field[] fields = clazz.getDeclaredFields();
       //for (Field field : fields) {
       //    System.out.println(field.getName());
       //}

        "aaa".intern();

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

    }


    @Test
    public void show(){
        byte  a = 127;
        System.out.println(a);
        a++;
        System.out.println(a);
    }

}
