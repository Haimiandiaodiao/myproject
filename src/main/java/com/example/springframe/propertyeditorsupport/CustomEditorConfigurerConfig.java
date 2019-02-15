package com.example.springframe.propertyeditorsupport;

import com.example.entity.springbeanlifeshow.Car;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 18:14 2019/1/30
 */
@Configuration
public class CustomEditorConfigurerConfig {

    /**
     * 注册自定义的属性编辑器
     * @Author:Dyy
     * @Description:
     * @Date: Created in 18:22 2019/1/30
     * @param
     */
    @Bean
    public CustomEditorConfigurer configCar(){
        CustomEditorConfigurer confi = new CustomEditorConfigurer();
        Map<Class<?>,Class<? extends java.beans.PropertyEditor>> propery= new HashMap();
        propery.put(Car.class,MyCarEditor.class);
        confi.setCustomEditors(propery);
        return  confi;
    }
}
