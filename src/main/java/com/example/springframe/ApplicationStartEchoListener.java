package com.example.springframe;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 14:07 2019/1/24
 */
public class ApplicationStartEchoListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("-------->我也不知道什么时候启动的----------");
    }
}
