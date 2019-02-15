package com.example.springframe.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 12:46 2019/1/31
 */
@Component
public class MailSendListenerSecond implements ApplicationListener<MailSendEvent> {

    @Override
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        System.out.println("--->监听器发送第二封邮件给-->"+mailSendEvent.getTo());
    }
}
