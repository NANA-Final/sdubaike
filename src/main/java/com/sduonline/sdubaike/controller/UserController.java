package com.sduonline.sdubaike.controller;

import com.sduonline.sdubaike.entity.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sduonline.sdubaike.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户请求控制
 */
@RestController
@RequestMapping(value = "/user")
public class UserController{

    @Autowired
    UserService userService;

    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map login(User user, HttpSession session)
    {
        return userService.login(user,session);
    }

    //注销
    @RequestMapping(value = "/unlogin",method = RequestMethod.POST)
    public Map unlogin(HttpSession session)
    {
        return userService.unlogin(session);
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map register(User user)
    {
        return userService.register(user);
    }

    //更新用户信息
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(User user)
    {
        return userService.update(user);
    }

    //获取已登录用户信息
    @RequestMapping(value = "/get_logined_user",method = RequestMethod.POST)
    public Map getUserInformation(HttpSession session)
    {
        return userService.getLoginedUser(session);
    }

    //按ID查找用户
    @RequestMapping(value = "/get_user_information",method = RequestMethod.POST)
    public Map getUserInformationById(int userId)
    {
        return userService.getUserByUserId(userId);
    }

    //按用户名查找用户
    @RequestMapping(value = "/get_user_by_username",method = RequestMethod.POST)
    public Map getUserInformationByUsername(String username)
    {
        return userService.getUserByUsername(username);
    }

}