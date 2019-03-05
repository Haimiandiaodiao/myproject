package com.example.entity.springbeanlifeshow;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 19:07 2019/1/29
 */
//@Component
@Data
public class B {
    private String name;
    private A a;
}
