package com.example.springframe.springevent;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * 这个是自定义的发送邮件的事件
 * @Author:Dyy
 * @Description:
 * @Date: Created in 12:40 2019/1/31
 */
@Getter
public class MailSendEvent extends ApplicationContextEvent {
    private String to;

    public MailSendEvent(ApplicationContext source,String to) {
        super(source);
        this.to = to;
    }
}
