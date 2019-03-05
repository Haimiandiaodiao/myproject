package com.example.springframe.mvc;

import com.example.entity.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 12:49 2019/3/5
 */
@Configuration
public class MvcConfiguration {

    //通过了BeanPostProcessor进行了手动添加xml的解析器
    //@Bean
    public static MarshallingHttpMessageConverter registerMessageConverter(){
        MarshallingHttpMessageConverter converter = new MarshallingHttpMessageConverter();
        XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
        //设置解析驱动器
        StaxDriver staxDriver = new StaxDriver();
        xStreamMarshaller.setStreamDriver(staxDriver);
        Map alias = new HashMap<>();

        alias.put("user",User.class);
        alias.put("User",User.class);
        xStreamMarshaller.setAliases(alias);


        converter.setMarshaller(xStreamMarshaller);
        converter.setUnmarshaller(xStreamMarshaller);

        return  converter;
    }
}
