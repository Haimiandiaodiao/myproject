package com.example.springframe.applicationautobindconfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 18:51 2019/1/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyInfo{
    private String name;
    private Integer age;
    private String address;

    @Override
    public String toString() {
        return "MyInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}