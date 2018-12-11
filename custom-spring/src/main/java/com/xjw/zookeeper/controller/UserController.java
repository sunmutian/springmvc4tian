package com.xjw.zookeeper.controller;

import com.xjw.zookeeper.entity.JsonResult;
import com.xjw.zookeeper.entity.User;
import com.xjw.zookeeper.entity.ZkServerInfo;
import com.xjw.zookeeper.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户列表
     */
    @RequestMapping("/list")
    public ModelAndView list() throws Exception {
        ModelAndView view = new ModelAndView();
        List<User> list = userService.getZkServerInfoByPage(1, 10);
        view.addObject("serverInfos", list);
        view.setViewName("user/list");
        return view;
    }


    /**
     * 添加用户信息弹框
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd() throws Exception {
        ModelAndView view = new ModelAndView();
        view.setViewName("user/add");
        return view;
    }

    /**
     * 添加用户信息弹框
     */
    @RequestMapping("/add")
    public ModelAndView add() throws Exception {
        System.out.println("添加用户信息弹框");
        ModelAndView view = new ModelAndView();
        view.setViewName("user/list");
        return view;
    }

    /**
     * 添加用户信息
     */
    @RequestMapping("/ajaxAddUserInfo")
    public JsonResult ajaxAddServerInfo(User user) throws Exception {
        System.out.println("添加用户信息" + user.getPassWord());
        JsonResult jsonResult = new JsonResult(false, "");
        /*int i = service.addZkServerInfo(zkServerInfo);
        if (i > 0) {
            jsonResult.setSuccess(true);
        }*/
        jsonResult.setSuccess(true);
        return jsonResult;
    }
}
