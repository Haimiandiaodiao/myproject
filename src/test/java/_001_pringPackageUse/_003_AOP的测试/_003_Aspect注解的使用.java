package _001_pringPackageUse._003_AOP的测试;

import com.example.server.waiter.*;
import com.example.server.waiter.aspectj.EnableSellerAspect;
import com.example.server.waiter.aspectj.PreGreetingAspect;
import com.example.server.waiter.aspectj.TestAspect;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/16 11:13 PM<br/>
 */
public class _003_Aspect注解的使用 {

    @Test
    public void 基础的使用() {
        PointcutWaiter wa = new PointcutWaiter();

        AspectJProxyFactory fa = new AspectJProxyFactory();

        fa.setTarget(wa);
        fa.addAspect(PreGreetingAspect.class);
        PointcutWaiter proxy = (PointcutWaiter)fa.getProxy();

        proxy.serverTo("Dyy");
        proxy.greetTo("Dyy");

    }

    @Test
    public void 引介切面() {
        NaiveWaiter waiter = new NaiveWaiter();
        AspectJProxyFactory fa = new AspectJProxyFactory();

        fa.setTarget(waiter);
        //这一点注意一个是使用JDK代理一个是使用CGLib进行代理
        //fa.setOptimize(true);
        fa.setInterfaces(Waiter.class);
        fa.addAspect(EnableSellerAspect.class);
        Waiter proxy = (Waiter)fa.getProxy();

        proxy.serveTo("Dyy");

        Seller proxy1 = (Seller) proxy;
        proxy1.sell("苹果");
    }

    @Test
    public void 注解标示的方() {
        NaughtWaiter waiter = new NaughtWaiter();
        AspectJProxyFactory fa = new AspectJProxyFactory();

        fa.setTarget(waiter);
        //这一点注意一个是使用JDK代理一个是使用CGLib进行代理
        //fa.setOptimize(true);
        fa.setInterfaces(Waiter.class);
        fa.addAspect(TestAspect.class);
        Waiter proxy = (Waiter)fa.getProxy();

        proxy.serveTo("Dyy");
        proxy.greetTo("Dyy");
    }
}
