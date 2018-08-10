package com.tian.springmvc.controller;

import com.tian.springmvc.annotation.Controller;
import com.tian.springmvc.annotation.RequestMapping;

/**
 * Copyright © 2018 上海金互行金融服务有限公司. All rights reserved. *
 * <p>
 * 注册 TODO
 *
 * @Author tianweichang
 * @Date 2018-08-10 15:25
 **/
@Controller("register")
@RequestMapping("/register")
public class RegisterController extends AbstractTemplate {

    @RequestMapping("/hello")
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
