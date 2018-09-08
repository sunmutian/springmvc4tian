package com.tian.springbootdemo.controller;

import com.tian.springbootdemo.dao.domain.User;
import com.tian.springbootdemo.dao.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 17
 * @Description:
 */
@RestController
public class HelloController {

    @Resource
    private UserDao userDao;

    @RequestMapping("/hello")
    public User hello() {
        User user = userDao.getUserById(1);
        System.out.println(user);
        return user;
    }

}
