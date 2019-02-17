package com.example;

import com.example.entity.springbeanlifeshow.*;
import com.example.springframe.applicationautobindconfig.MyInfo;
import com.example.springframe.applicationautobindconfig.MyPrefixConfig;
import com.example.springframe.applicationautobindconfig.ProfilesBookInfo;
import com.example.springframe.componentscantype.MyCompontentScanFilter;
import com.example.springframe.springevent.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 10:47 2019/1/24
 */
//1.声明是一个rest的controller
@RestController
//2.开启启动注解功能
@ComponentScan(basePackages = "com.example"
        ,excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com\\.example\\.springframe\\.applicationstartrun\\.(ApplicationStartApplicationRunner|ApplicationStartCommandLineRunner)"})}
        )
@SpringBootApplication
//开启aspect的自动代理创建器功能
@EnableAspectJAutoProxy
public class SpringBootTestApplicaiton {

    @Autowired
    private  MyPrefixConfig myPrefixConfig;
    @Autowired
    private ProfilesBookInfo profilesBookInfo;
    @Autowired
    private MyInfo myInfo;
    @Autowired
    private Map myCache;
    @Autowired
    @Qualifier("personList")
    private List<MyInfo> personList;
    @Autowired
    private School school;
    @Autowired
    private A a;
    @Autowired
    private B b;
    //=======测试自定义属性编辑器
    @Autowired
    private Boss boss;
    @Autowired
    private Car car;
    @Autowired
    private MailSender mailSender;


    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }


    @RequestMapping(value = "/serversInfo",method = RequestMethod.GET)
    String serverInfo(){
        String s = myPrefixConfig.toString();
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/bookInfo",method = RequestMethod.GET)
    String bookInfo(){
        String s = profilesBookInfo.toString();
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/myInfo",method = RequestMethod.GET)
    String myInfo(){
        String s = myInfo.toString();
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/myCache",method = RequestMethod.GET)
    String myCache(){
        String s = myCache.toString();
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/personList",method = RequestMethod.GET)
    String personList(){
        String s = personList.toString();
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/school",method = RequestMethod.GET)
    String school(){
        String s = school.toString();
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/boss",method = RequestMethod.GET)
    String boss(){
        String s = boss.toString();
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/sendMail",method = RequestMethod.GET)
    String sendMail(){
        mailSender.sendMail("811595981@qq.com");
        return "成功";
    }

    //3.启动spring的成功程序
    public static void main (String[] args){
        SpringApplication application = new SpringApplication(SpringBootTestApplicaiton.class);
        application.run(args);
    }
}
