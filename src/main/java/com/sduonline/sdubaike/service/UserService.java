package com.sduonline.sdubaike.service;


import com.sduonline.sdubaike.entity.domain.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户操作逻辑接口
 */
public interface UserService {

    //登录
    Map login(User user, HttpSession session);

    //注销
    Map unlogin(HttpSession session);

    //注册
    Map register(User user);

    //更新
    Map update(User user);

    Map getLoginedUser(HttpSession session);
    Map getUserByUserId(int userId);
    Map getUserByUsername(String username);
}