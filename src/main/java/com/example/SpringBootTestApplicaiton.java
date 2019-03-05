package com.example;

import com.alibaba.fastjson.JSON;
import com.example.entity.User;
import com.example.entity.springbeanlifeshow.*;
import com.example.springframe.applicationautobindconfig.MyInfo;
import com.example.springframe.applicationautobindconfig.MyPrefixConfig;
import com.example.springframe.applicationautobindconfig.ProfilesBookInfo;
import com.example.springframe.springevent.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired(required = false)
    private A a;
    @Autowired(required = false)
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

    @RequestMapping("/niu")
    String niu(HttpServletRequest request) {
        String query = request.getParameter("query");
        Map map = JSON.parseObject(query, Map.class);
        System.out.println(query);

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

    //使用@MatrixVariable进行参数封装
    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.GET)
    String bookSend(@PathVariable String bookId, @MatrixVariable(value = "a",pathVar = "bookId") int a){
        return "参数绑定";
    }

    @RequestMapping("/submitA")
    String commandSubmit(A a){
        return "命令方式提交参数";
    }

    //3.启动spring的成功程序
    public static void main (String[] args){
        SpringApplication application = new SpringApplication(SpringBootTestApplicaiton.class);
        application.run(args);
    }

    @RequestMapping(value = "/xmlSumbitUserInfo",method = RequestMethod.POST,produces = {"application/json"} )
    @ResponseBody
    User xmlSumbitUserInfo(@RequestBody User a){

        return a;
    }

}
