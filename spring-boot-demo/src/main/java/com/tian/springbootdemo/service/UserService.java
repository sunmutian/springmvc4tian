package com.tian.springbootdemo.service;

import com.tian.springbootdemo.dao.domain.User;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 18:04
 * @Description:
 */
public interface UserService {
    User getUserById(int id);

    int updateUser( User user);

    int insertUser(User user);

    int deleteUserById(int id);
}
