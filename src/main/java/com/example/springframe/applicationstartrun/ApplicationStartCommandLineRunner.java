package com.example.springframe.applicationstartrun;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 在这个方法里也可以注入参数因为他是在所有bean实例化之后执行的
 * 都是在SpringApplication.run()完成之前调用
 * @Author:Dyy
 * @Description:
 * @Date: Created in 16:18 2019/1/25
 */
@Component
@Order(10000)
public class ApplicationStartCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("1。1------使用CommandLineRunner启动时执行参数为-----"+ Arrays.toString(args));
    }
}
