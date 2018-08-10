package com.tian.springmvc.controller;

import com.tian.springmvc.annotation.Controller;
import com.tian.springmvc.annotation.RequestMapping;

/**
 *
 * 登录
 *
 * @Author tianweichang
 * @Date 2018-08-10 15:25
 **/
@Controller("login")
@RequestMapping("/login")
public class LoginController extends AbstractTemplate {

    @RequestMapping("/hello")
    @Override
    public void execute() {
        super.execute();
    }

    @Override
    protected void checkParameters() {
        System.out.println("login检查参数完毕");
    }

    @Override
    protected void parseRequestParameters() {
        System.out.println("login解析参数完毕");
    }

    @Override
    protected void doBusiness() {
        System.out.println("login中");
    }

    @Override
    protected void assembleResponseParameters() {
        System.out.println("login成功");
    }
}
