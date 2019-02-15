package com.example.springframe.applicationstartarguments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 使用ApplicationArguments来注入启动时参数
 * @Author:Dyy
 * @Description:
 * @Date: Created in 13:27 2019/1/25
 */
@Component
public class InitBeanWithArgs {

    @Autowired
    public InitBeanWithArgs(ApplicationArguments args){
        boolean dyyOP = args.containsOption("Dyy");
        boolean zzqOp = args.containsOption("Zzq");

        if(dyyOP){
            System.out.println("-----捕捉到启动参数Dyy----");
            List<String> dyy = args.getOptionValues("Dyy");
            System.out.println("-----Dyy启动项的参数-----"+dyy);
            System.out.println("-----Dyy启动项的参数个数-----"+dyy.size());
        }else{
            System.out.println("-----没有捕捉到启动参数Dyy-----");
        }

        if(zzqOp){
            System.out.println("-----捕捉到启动参数Zzq----");
            List<String> zzq = args.getOptionValues("Zzq");

            System.out.println("-----Zzq启动项的参数-----"+zzq);
            System.out.println("-----Zzq启动项的参数个数-----"+zzq.size());
        }else{
            System.out.println("-----没有捕捉到启动参数Zzq-----");
        }



        
    }
}
