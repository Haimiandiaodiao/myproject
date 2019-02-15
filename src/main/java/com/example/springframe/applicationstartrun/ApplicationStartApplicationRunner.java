package com.example.springframe.applicationstartrun;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 在这个方法里也可以注入参数因为他是在所有bean实例化之后执行的
 * 都是在SpringApplication.run()完成之前调用
 * 和实现CommandLineRunner是一样的只是参数不一样
 * @Author:Dyy
 * @Description:
 * @Date: Created in 16:14 2019/1/25
 */
@Component

public class ApplicationStartApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("1。------使用ApplicationRunner启动时执行参数为-----"+args.getOptionValues("Dyy"));
    }
}
