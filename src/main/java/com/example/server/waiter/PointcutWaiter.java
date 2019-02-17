package com.example.server.waiter;

/**
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/16 7:34 PM<br/>
 */
public class PointcutWaiter {

    public void greetTo(String name){
        System.out.println("waiter greet to "+name+"....");
    }

    public void serverTo(String name){
        System.out.println("waiter serving "+name+"...");
    }
}
