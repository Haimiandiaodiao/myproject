package com.example.springframe.beanInstanceconfig;

import com.example.entity.springbeanlifeshow.School;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 自定义的BeanPostProcessor 实体投递处理器
 * 只要被spring加入到容器中，spring就会自动注册为主键来运行期功能
 * 【注意】所以也总结出来的规律是Spring会一开始会先实例注册Spring的组件来完成他的功能
 * @Author:Dyy
 * @Description:
 * @Date: Created in 14:59 2019/1/29
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    public MyBeanPostProcessor() {
        super();
        //是在一开始就注册的
        System.out.println("--->【MyBeanPostProcessor】的构造器");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--->【BeanPostProcessor】接口的PostProcessBeforeInitialization方法可以对属性进行修改");
        if(bean.getClass() == School.class){
            System.out.println("--->BeanPost的ProcessBefore中捕捉到School属性下面打印他的属性");
            System.out.println(bean.toString());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--->【BeanPostProcessor】接口的PostProcessAfterInitialization方法可以对属性进行修改");
        if(bean.getClass() == School.class){
            System.out.println("--->BeanPost的ProcessAfter中捕捉到School属性下面打印他的属性");
            System.out.println(bean.toString());
        }

        return bean;
    }
}
