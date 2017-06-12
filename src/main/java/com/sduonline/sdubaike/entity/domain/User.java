package com.sduonline.sdubaike.entity.domain;

import lombok.Data;

/**
 * 用户类
 */
@Data
public class User {

    /*用户ID*/
    private Integer userId;
    /*用户名*/
    private String username;
    /*密码*/
    private String password;
    /*头像*/
    private String headImage;
    private String name;
    private String major;
    private Integer age;
    private Integer grade;
    private String contact;
    private String campus;

}
