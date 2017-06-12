package com.sduonline.sdubaike.dao;


import com.sduonline.sdubaike.entity.domain.User;
import org.springframework.stereotype.Repository;

/**
 * 对用户表的操作
 */
@Repository
public interface UserDao {

    //插入用户
    int insert(User user);

    //更新用户信息
    int update(User user);

    User selectByUsername(String username);

    User selectById(Integer entryContenterId);
}