package com.xjw.zookeeper.controller;

import com.xjw.zookeeper.entity.User;
import com.xjw.zookeeper.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    /**
     * 用户登录页面
     */
    @RequestMapping({"/login", ""})
    public String login(Model model) {
        model.addAttribute("url", "");
        return "/login";
    }

    /**
     * 用户登录
     */
    @PostMapping("/2login")
    public Map<String, String> toLogin(HttpSession session, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(6);
        Map<String, String[]> parameter = request.getParameterMap();
        if (parameter == null ) {
            map.put("result", "failed");
            map.put("msg", "用户名或者密码为空");
            return map;
        }
        if (StringUtils.isEmpty(parameter.get("username")[0])||StringUtils.isEmpty(parameter.get("password")[0])) {
            map.put("result", "failed");
            map.put("msg", "用户名或者密码为空");
            return map;
        }
        String username = parameter.get("username")[0];
        String password = parameter.get("password")[0];
        System.out.println(username + "," + password);
        System.out.println("登录");
        //查询数据库
        User userData = new User();
        userData.setId(1);
        userData.setPassWord("123456");
        userData.setUserName("zhangsan");

        session.setAttribute(Constants.SESSION + userData.getId(), userData);
        session.setAttribute(Constants.SESSION_KEY, userData);
        map.put("result", "success");
        map.put("msg", "登录成功");
        return map;
    }
}
