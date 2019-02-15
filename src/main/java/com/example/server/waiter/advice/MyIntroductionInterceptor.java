package com.example.server.waiter.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 19:30 2019/1/31
 */
public class MyIntroductionInterceptor extends DelegatingIntroductionInterceptor implements MyIntroducton1 {
    
    /**增加的自定义属性*/
    private String diyProperty;
    /**对自定义属性的标识*/
    private boolean isFlag;

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object result = null;
        if(isFlag){
            System.out.println("------>进入到引介增强之中 start<------");
            result = super.invoke(mi);
            System.out.println("------>自定义属性的值<------"+diyProperty);
            System.out.println("------>进入到引介增强之中 end<------");
        }else{
            result = super.invoke(mi);
        }
        return result;
    }


    @Override
    public void setDiyProperty(String myProperty) {
        this.diyProperty = myProperty;
    }

    @Override
    public void setIsFlag(boolean flag) {
        this.isFlag = flag;
    }
}
