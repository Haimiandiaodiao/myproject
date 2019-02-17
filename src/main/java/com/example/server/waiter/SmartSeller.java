package com.example.server.waiter;

import com.example.server.waiter.Seller;

/**
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/17 10:04 AM<br/>
 */
public class SmartSeller implements Seller {

    @Override
    public void sell(String goods) {
        System.out.println("我买给你的商品是"+goods);
    }

}
