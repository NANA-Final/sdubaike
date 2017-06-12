package com.sduonline.sdubaike.service.impl;

import com.sduonline.sdubaike.dao.UserDao;
import com.sduonline.sdubaike.entity.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sduonline.sdubaike.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户操作逻辑
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    //登录
    public Map login(User user, HttpSession session) {
        Map map = new HashMap();
        User realuser=userDao.selectByUsername(user.getUsername());
        if (realuser.getPassword().equals(user.getPassword()))
        {
            session.setAttribute("userId",realuser.getUserId());
            map.put("message","succeed");
        }
        else map.put("message","failed");
        return map;
    }

    //注销
    public Map unlogin(HttpSession session) {
        Map map = new HashMap();
        session.setAttribute("userId",null);
        map.put("message","succeed");
        return map;
    }

    //注册
    public Map register(User user){
        userDao.insert(user);
        Map map = new HashMap();
        map.put("message","succeed");
        return map;
    }

    public Map getLoginedUser(HttpSession session) {
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        User user=userDao.selectById(userId);
        Map map = new HashMap();
        map.put("message","succeed");
        map.put("data",user);
        return map;
    }

    public Map getUserByUserId(int userId) {
        User user=userDao.selectById(userId);
        Map map = new HashMap();
        map.put("message","succeed");
        map.put("data",user);
        return map;
    }

    public Map getUserByUsername(String username) {
        User user=userDao.selectByUsername(username);
        Map map = new HashMap();
        map.put("message","succeed");
        map.put("data",user);
        return map;
    }

    //修改用户信息
    public Map update(User user) {
        userDao.update(user);
        Map map = new HashMap();
        map.put("message","succeed");
        return map;
    }

}