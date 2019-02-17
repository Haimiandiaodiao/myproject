package com.example.server.waiter.aspectj;

import com.example.server.waiter.Seller;
import com.example.server.waiter.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 这个是引介增强
 * 让NaiveWaiter拥有Seller接口的口功能
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/17 10:06 AM<br/>
 */
@Aspect
public class EnableSellerAspect {

    //1.下面的Seller 是说明要实现的接口
    //2.defaultImpl是提供这个要实现的接口的默认实现
    //3.value是要给哪些类增加接口功能
    @DeclareParents(value = "com.example.server.waiter.NaiveWaiter",defaultImpl = SmartSeller.class)
    public Seller seller;
}
