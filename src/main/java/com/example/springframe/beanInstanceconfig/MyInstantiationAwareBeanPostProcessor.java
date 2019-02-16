package com.example.springframe.beanInstanceconfig;

import com.example.entity.springbeanlifeshow.School;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 15:43 2019/1/29
 */
@Component
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    /**
     * 实例化Bean之前调用的方法
     * @Author:Dyy
     * @Description:
     * @Date: Created in 16:00 2019/1/29
     * @param beanClass
     * @param beanName
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("--->调用【InstantiationAwareBeanPostProcessorAdapter】的postProcessBeforeInstantiation方法");
        Object o = super.postProcessBeforeInstantiation(beanClass, beanName);
        return o;

    }
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("--->调用【InstantiationAwareBeanPostProcessorAdapter】postProcessAfterInstantiation方法");
        return super.postProcessAfterInstantiation(bean, beanName);
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--->调用【InstantiationAwareBeanPostProcessorAdapter】postProcessBeforeInitialization");

        return super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--->调用【InstantiationAwareBeanPostProcessorAdapter】postProcessAfterInitialization");

        return super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("--->调用【InstantiationAwareBeanPostProcessorAdapter】postProcessProperties");
        if(bean.getClass() == School.class){
            System.out.println("");
        }
        return super.postProcessProperties(pvs, bean, beanName);
    }

}
