package com.example.entity.exclude;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 13:37 2019/2/28
 */
public class Son extends Fu {
    private  int num = 100;

    @Override
    public void show(){
        System.out.println("子类的show方法");
    }

    public void panduan(){
        System.out.println("this的地址："+this);
        super.dizhi();
        dizhi();
    }
    @Override
    public void dizhi(){
        System.out.println("子类的地址"+this);
    }
}
