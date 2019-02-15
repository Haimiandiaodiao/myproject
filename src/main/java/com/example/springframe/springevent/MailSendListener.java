package com.example.springframe.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义邮件发送监听器
 * @Author:Dyy
 * @Description:
 * @Date: Created in 12:44 2019/1/31
 */
@Component
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    @Override
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        System.out.println("--->监听器发送了第一封邮件给-->"+mailSendEvent.getTo());
    }
}
