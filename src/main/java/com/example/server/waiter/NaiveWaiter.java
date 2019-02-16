package com.example.server.waiter;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 17:24 2019/1/31
 */
public class NaiveWaiter implements Waiter {
    private String WaiterName;
    @Override
    public void greetTo(String name) {
        System.out.println("你好,"+name+"....");
    }

    @Override
    public String serveTo(String name) {
        System.out.println("我为你服务,"+name+"....");
        return "serveTo方法返回";
    }

    @Override
    public void throwException() {
        System.out.println("进入了抛出异常的方法");
        throw  new RuntimeException("抛出了异常");
    }


    public void exceptionMethod(){
        int a = 1/0;
    }
}
