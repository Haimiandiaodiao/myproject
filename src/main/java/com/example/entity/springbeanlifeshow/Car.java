package com.example.entity.springbeanlifeshow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 17:52 2019/1/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int maxSpeed;
    private String brand;
    private double price;
}
