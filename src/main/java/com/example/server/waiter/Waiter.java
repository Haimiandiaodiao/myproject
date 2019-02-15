package com.example.server.waiter;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 17:23 2019/1/31
 */
public interface Waiter {
    void greetTo(String name);

    String serveTo(String name);

    void throwException();
}
