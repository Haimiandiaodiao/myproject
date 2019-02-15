package com.example.springframe.springevent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 12:47 2019/1/31
 */
@Component
public class OtherListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("其他的事件监听器"+applicationEvent.toString());

    }
}
