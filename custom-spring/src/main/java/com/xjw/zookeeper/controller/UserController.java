package com.xjw.zookeeper.controller;

import com.xjw.zookeeper.entity.JsonResult;
import com.xjw.zookeeper.entity.User;
import com.xjw.zookeeper.entity.ZkServerInfo;
import com.xjw.zookeeper.service.UserService;
import com.xjw.zookeeper.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/ajaxAddUserInfo")
    public JsonResult add(HttpSession session, User parameter) throws Exception {
        JsonResult jsonResult = new JsonResult(false, "");
        User user = (User) session.getAttribute(Constants.SESSION_KEY);
        if (user == null) {
            jsonResult.setSuccess(false);
            return jsonResult;
        }
        if (parameter == null) {
            jsonResult.setSuccess(false);
            return jsonResult;
        }
        if (StringUtils.isEmpty(parameter.getPassWord()) || StringUtils.isEmpty(parameter.getUserName())) {
            jsonResult.setSuccess(false);
            return jsonResult;
        }
        if (userService.addUserInfo(parameter) > 0) {
            System.out.println("新增成功");
            jsonResult.setSuccess(true);
            return jsonResult;
        }
        jsonResult.setSuccess(false);
        return jsonResult;
    }


}
