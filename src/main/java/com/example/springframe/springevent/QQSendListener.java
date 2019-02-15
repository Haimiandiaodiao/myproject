package com.example.springframe.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 13:00 2019/1/31
 */
@Component
public class QQSendListener implements ApplicationListener<QQSendEven> {

    @Override
    public void onApplicationEvent(QQSendEven qqSendEven) {
        System.out.println("QQ发送监听器接受到事件通知");
    }
}
