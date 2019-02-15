package com.example.springframe.springevent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 事件源也就是发送邮件
 * @Author:Dyy
 * @Description:
 * @Date: Created in 12:49 2019/1/31
 */
@Component
public class MailSender implements ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.ctx = applicationContext;
    }

    public void sendMail(String to){
        System.out.println("模拟邮件发送");
        MailSendEvent mse = new MailSendEvent(this.ctx, to);
        ctx.publishEvent(mse);
    }

}
