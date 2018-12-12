package com.tian.spring.mvc.service;

import com.tian.spring.mvc.dao.domain.User;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 18:04
 * @Description:
 */
public interface UserService {
    User getUserById(int id);

    int updateUser(User user);

    int insertUser(User user);

    int deleteUserById(int id);
}
