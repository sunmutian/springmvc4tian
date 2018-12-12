package com.tian.spring.mvc.controller;

import com.tian.spring.mvc.dao.domain.User;
import com.tian.spring.mvc.rep.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: 小田哥
 * @date: 2018/11/17 09
 * @Description: api接口
 */
@RequestMapping("/api")
@RestController
public class LoginController extends AbstractTemplate {
    @PostMapping(value = "/login")
    @Override
    public Result execute() {
        return super.execute();
    }
    @Override
    protected void parseRequestParameters() {
        System.out.println("解析登录参数");
    }

    @Override
    protected Object doBusiness() {
        System.out.println("通过用户名查询是否存在此用户");
        System.out.println("校验用户密码是否正确");
        System.out.println("登录成功");
        User user = new User();
        user.setName("小田哥");
        user.setId(1);
        user.setAge(20);
        user.setSex("man");
        return user;
    }

    @Override
    protected Result assembleResponseParameters(Object object) {
        System.out.println("LoginController 返回参数");
        Result result = new Result("200", "登录成功");
        result.setData(object);
        return result;
    }
}
