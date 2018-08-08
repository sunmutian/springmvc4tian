package com.tian.springmvc.controller;

import com.tian.springmvc.annotation.Controller;
import com.tian.springmvc.annotation.Qualifier;
import com.tian.springmvc.annotation.RequestMapping;
import com.tian.springmvc.service.DemoService;

/**
 * 使用自定义的注解来模拟实现Spring中的SpringMVC
 *
 * @Author tianweichang
 * @Date 2018-08-08 10:39
 **/
@Controller("demo")
@RequestMapping("/demo")
public class DemoController {

    @Qualifier("demoService")
    private DemoService demoService;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("invoke DemoController hello ");
        demoService.insert();
        return "invoke Success";
    }
}
