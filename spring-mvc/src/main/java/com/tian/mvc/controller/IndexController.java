package com.tian.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: 小田哥
 * @date: 2018/12/9 17
 * @Description:
 */
@RestController
public class IndexController{

    @GetMapping({"/", ""})
    public String index(Model model) {
        model.addAttribute("message", "hello world");
        return "index";
    }
}
