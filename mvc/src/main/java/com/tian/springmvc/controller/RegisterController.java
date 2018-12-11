package com.tian.springmvc.controller;

import com.tian.springmvc.annotation.Controller;
import com.tian.springmvc.annotation.RequestMapping;

/**
 * @Author 小田哥
 * @Date 2018-08-10 15:25
 **/
@Controller
@RequestMapping("/user")
public class RegisterController extends AbstractTemplate {

    @RequestMapping("/register")
    @Override
    public void execute() {
        super.execute();
    }

    @Override
    protected void checkParameters() {
        System.out.println("register检查参数完毕");
    }

    @Override
    protected void parseRequestParameters() {
        System.out.println("register解析参数完毕");
    }

    @Override
    protected void doBusiness() {
        System.out.println("register中");
    }

    @Override
    protected void assembleResponseParameters() {
        System.out.println("register成功");
    }
}
