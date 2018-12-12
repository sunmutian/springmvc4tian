package com.tian.spring.mvc.service.impl;

import com.tian.spring.mvc.dao.domain.User;
import com.tian.spring.mvc.dao.mapper.UserDao;
import com.tian.spring.mvc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 18
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }
}
