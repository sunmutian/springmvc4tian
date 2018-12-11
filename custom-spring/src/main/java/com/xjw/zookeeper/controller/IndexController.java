package com.xjw.zookeeper.controller;

import com.xjw.zookeeper.entity.User;
import com.xjw.zookeeper.service.UserService;
import com.xjw.zookeeper.util.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 项目名称：zmc
 * 实现功能：
 * 类名称：IndexController
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月26日下午8:58:55
 * 修改人：
 * 修改时间：
 * 版权 :
 * 修改备注：
 */
@RestController
public class IndexController {
    /**
     * 首页
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpSession session) {
        ModelAndView view = new ModelAndView();
        User user = (User) session.getAttribute(Constants.SESSION_KEY);
        if (user == null) {
            view.setViewName("login");
            return view;
        }
        //用户名
        view.addObject("userName", user.getUserName());
        view.setViewName("index");
        return view;
    }
}
