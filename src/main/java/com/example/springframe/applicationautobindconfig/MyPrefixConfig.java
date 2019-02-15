package com.example.springframe.applicationautobindconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 使用@CONfigurationProperties可以绑定yml中的属性到对象上
 * @Author:Dyy
 * @Description:
 * @Date: Created in 15:26 2019/1/27
 */
@Data
@Configuration
@ConfigurationProperties(prefix="my")
public class MyPrefixConfig {
    private List<String> servers;


    @Override
    public String toString() {
        return "MyPrefixConfig{" +
                "servers=" + servers +
                '}';
    }
}
