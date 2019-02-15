package com.example.springframe.springevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 13:00 2019/1/31
 */
public class QQSendEven extends ApplicationContextEvent{
    private String QQ;

    public QQSendEven(ApplicationContext source,String QQ) {
        super(source);
        this.QQ = QQ;
    }
}
