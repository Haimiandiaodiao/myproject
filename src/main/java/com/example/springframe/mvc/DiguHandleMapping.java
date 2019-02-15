package com.example.springframe.mvc;

import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义HandlerMapping的实现
 * @Author:Dyy
 * @Description:
 * @Date: Created in 15:16 2019/1/28
 */
public class DiguHandleMapping implements HandlerMapping {

    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        //1.得到请求的SessionId
        String requestedSessionId = request.getRequestedSessionId();
        System.out.println("--DiguHandler接收到的请求的sessionId--"+requestedSessionId);
        //2.得到请求的URL
        String requestURI = request.getRequestURI();
        System.out.println("--DiguHandler接收到的请求路径---"+requestURI);
        //3.得到请求方式
        String method = request.getMethod();
        System.out.println("--DiguHandler接收到的请求方式---"+method);

        //处理所有已土豆开始的请求
        if(requestURI.startsWith("/tudou")){
            if(method.equalsIgnoreCase("GET")){
                //return  "买地瓜对应的Handler";
            }else if (method.equalsIgnoreCase("POST")){
                //return  "买地瓜对应的Handler";
            }
        }

        return null;
    }
}
