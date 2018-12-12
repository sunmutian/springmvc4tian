package com.tian.spring.mvc.controller;

import com.tian.spring.mvc.dao.domain.User;
import com.tian.spring.mvc.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/test")
    public User test() {
        User user = new User();
        user.setAge(22);
        user.setId(10000);
        user.setName("张三");
        System.out.println(user);
        return user;
    }


}
