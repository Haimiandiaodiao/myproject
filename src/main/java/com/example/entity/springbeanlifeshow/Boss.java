package com.example.entity.springbeanlifeshow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 17:53 2019/1/30
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boss {
    private String name;
    private Car car = new Car();
}
