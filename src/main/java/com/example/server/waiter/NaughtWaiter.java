package com.example.server.waiter;

import com.example.server.waiter.aspectj.NeedTest;

/**
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/17 11:08 AM<br/>
 */
public class NaughtWaiter implements Waiter {

    @NeedTest
    @Override
    public void greetTo(String name) {
        System.out.println("NaughtWaiter:greet to "+name+"...");
    }

    @Override
    public String serveTo(String name) {
        return null;
    }

    @Override
    public void throwException() {

    }
}
