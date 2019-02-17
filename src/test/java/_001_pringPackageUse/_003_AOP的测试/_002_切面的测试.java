package _001_pringPackageUse._003_AOP的测试;

import com.example.server.waiter.PointcutWaiter;
import com.example.server.waiter.NaviceSeller;
import com.example.server.waiter.pointcut.GreetingAdvisor;
import com.example.server.waiter.pointcut.GreetingDynamicPointcut;
import com.example.server.waiter.pointcut.advice.GreetingBeforeAdvice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

/**
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/16 7:56 PM<br/>
 */
public class _002_切面的测试 {


    @Test
    public void 静态方法切面的测试() {
        //代理对象
        PointcutWaiter pointcutWaiter = new PointcutWaiter();
        //增强
        GreetingBeforeAdvice greetingBeforeAdvice = new GreetingBeforeAdvice();
        //切面
        GreetingAdvisor greetingAdvisor = new GreetingAdvisor();
        //给切面设置增强
        greetingAdvisor.setAdvice(greetingBeforeAdvice);

        //生成代理工厂
        ProxyFactory pro = new ProxyFactory();
        //设置代理类
        pro.setTarget(pointcutWaiter);
        //设置切面
        pro.addAdvisor(greetingAdvisor);

        //生成代理
        PointcutWaiter proxy = (PointcutWaiter) pro.getProxy();

        proxy.greetTo("Dyy");
        proxy.serverTo("Dyy");

        //查看其他对象设置该切面是否有用
        NaviceSeller naviceSeller = new NaviceSeller();
        pro.setTarget(naviceSeller);

        NaviceSeller proxy1 = (NaviceSeller)pro.getProxy();
        proxy1.greetTo("ZZQ");

    }


    @Test
    public void 静态正则匹配的方法() {
        //1.声明正则匹配的切面
        RegexpMethodPointcutAdvisor regex = new RegexpMethodPointcutAdvisor();
        //设置一个正则表达式  ，注意他还有一个可以设置多个正则表达式的方法  setPatterns方法
        regex.setPattern(".*greet.*");
        //2.设置增强
        GreetingBeforeAdvice greetingBeforeAdvice = new GreetingBeforeAdvice();

        //给切面设置增强
        regex.setAdvice(greetingBeforeAdvice);


        //要代理的对象
        PointcutWaiter pointcutWaiter = new PointcutWaiter();

        //生成代理工厂
        ProxyFactory pro = new ProxyFactory();
        //设置代理类
        pro.setTarget(pointcutWaiter);
        //设置切面
        pro.addAdvisor(regex);

        //生成代理
        PointcutWaiter proxy = (PointcutWaiter) pro.getProxy();

        proxy.greetTo("Dyy");
        proxy.serverTo("Dyy");

        //查看其他对象设置该切面是否有用
        NaviceSeller naviceSeller = new NaviceSeller();
        pro.setTarget(naviceSeller);

        NaviceSeller proxy1 = (NaviceSeller)pro.getProxy();
        proxy1.greetTo("ZZQ");

    }


    @Test
    public void 动态正则匹配的方法() {
        GreetingBeforeAdvice greetingBeforeAdvice = new GreetingBeforeAdvice();

        GreetingDynamicPointcut dynamic = new GreetingDynamicPointcut();

        DefaultPointcutAdvisor poin = new DefaultPointcutAdvisor();
        poin.setPointcut(dynamic);
        poin.setAdvice(greetingBeforeAdvice);

        //要代理的对象
        PointcutWaiter pointcutWaiter = new PointcutWaiter();

        //生成代理工厂
        ProxyFactory pro = new ProxyFactory();
        //设置代理类
        pro.setTarget(pointcutWaiter);
        //设置切面
        pro.addAdvisor(poin);

        //生成代理
        PointcutWaiter proxy = (PointcutWaiter) pro.getProxy();

        proxy.greetTo("Dyy");
        proxy.serverTo("Dyy");

        proxy.greetTo("Peter");
        proxy.serverTo("Peter");

        proxy.greetTo("John");
        proxy.serverTo("John");
    }
}
