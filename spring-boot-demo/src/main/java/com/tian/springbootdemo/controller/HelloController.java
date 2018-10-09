package com.tian.springbootdemo.controller;

import com.tian.springbootdemo.dao.domain.User;
import com.tian.springbootdemo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 17
 * @Description: demo
 */
@RestController
public class HelloController {

    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public User hello() {
        User user = userService.getUserById(1);
        System.out.println(user);
        return user;
    }


}
