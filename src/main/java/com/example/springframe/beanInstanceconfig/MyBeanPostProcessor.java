package com.example.springframe.beanInstanceconfig;

import com.example.entity.springbeanlifeshow.School;
import com.example.springframe.mvc.MvcConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

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

        //设置Sprimg的删除分号内容为false
        if(bean.getClass() == RequestMappingHandlerMapping.class ){
            if(beanName.equalsIgnoreCase("requestMappingHandlerMapping")){
                RequestMappingHandlerMapping mapping = (RequestMappingHandlerMapping) bean;
                mapping.setRemoveSemicolonContent(false);

            }
        }

        //查看Springmvc默认加载的一些HttpMessageConverter
        if(bean.getClass() == RequestMappingHandlerAdapter.class){
            RequestMappingHandlerAdapter handlerAdapter = (RequestMappingHandlerAdapter) bean;
            List<HttpMessageConverter<?>> messageConverters = handlerAdapter.getMessageConverters();
            messageConverters.add(MvcConfiguration.registerMessageConverter());
            System.out.println("");
        }

        return bean;
    }
}
