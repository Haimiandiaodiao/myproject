package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 14:39 2019/3/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userName;

    private String password;

    private String realName;

    private Integer salary;
}
