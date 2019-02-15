package com.example.springframe.applicationautobindconfig;

import com.example.entity.springbeanlifeshow.Boss;
import com.example.entity.springbeanlifeshow.Car;
import com.example.entity.springbeanlifeshow.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 18:43 2019/1/27
 */
@Configuration
@Profile("master")
public class BeanAutoConfiguration {

    @Bean("myInfo")
    @ConfigurationProperties(prefix = "person-info")
    public MyInfo getBook(){
        return new MyInfo();
    }

    @Bean("myCache")
    @ConfigurationProperties(prefix = "cache")
    public Map getCache(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return objectObjectHashMap;
    }

    @Bean("personList")
    @ConfigurationProperties(prefix = "person-list")
    public List<MyInfo> getPersonList(){
        ArrayList<MyInfo> myInfos = new ArrayList<>();
        return  myInfos;
    }

    @Bean(value = "school",initMethod = "myInitMethod",destroyMethod = "myDestoryMethod")
    @Autowired
    public School getSchool(){
        School school = new School();
//        school.setName("天大");
////        school.setAddress("天津津南区");
////        school.setLevel(211);
////        school.setMyInfo(a);
        return school;
    }

    @Bean("boss")
    public Boss getBoss(){
        Boss boss = new Boss();
        return boss;
    }

    @Bean("car")
    public Car getCar(){
        Car boss = new Car();
        return boss;
    }
}

