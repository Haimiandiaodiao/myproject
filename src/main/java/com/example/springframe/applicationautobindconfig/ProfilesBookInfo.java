package com.example.springframe.applicationautobindconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 16:05 2019/1/27
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "book-info")
public class ProfilesBookInfo {

    private String bookName;

    private BigDecimal price;

    @Override
    public String toString() {
        return "ProfilesBookInfo{" +
                "name='" + bookName + '\'' +
                ", price=" + price +
                '}';
    }
}

