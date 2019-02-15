package com.example.springframe.beanInstanceconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义的BBean投递工厂当需要一个Bean时就投递给这个工厂
 * @Author:Dyy
 * @Description:
 * @Date: Created in 16:57 2019/1/29
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("---->【BeanFactoryPostProcessor】这是BeanFactoryPostProcessor实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("--->调用了【BeanFactoryPostProcessor】的postProcessBeanFactory方法");
        BeanDefinition school = configurableListableBeanFactory.getBeanDefinition("school");
        school.getPropertyValues().addPropertyValue("name","DUU");

        BeanDefinition boss = configurableListableBeanFactory.getBeanDefinition("boss");
        boss.getPropertyValues().addPropertyValue("car","红旗123,200,20000.00");


    }
}
