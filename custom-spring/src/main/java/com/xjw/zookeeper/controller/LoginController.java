package com.xjw.zookeeper.controller;

import com.xjw.zookeeper.entity.User;
import com.xjw.zookeeper.service.UserService;
import com.xjw.zookeeper.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    private UserService userService;

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
        try {
            Map<String, String[]> parameter = request.getParameterMap();
            if (parameter == null) {
                map.put("result", "failed");
                map.put("msg", "用户名或者密码为空");
                return map;
            }
            if (StringUtils.isEmpty(parameter.get("username")[0]) || StringUtils.isEmpty(parameter.get("password")[0])) {
                map.put("result", "failed");
                map.put("msg", "用户名或者密码为空");
                return map;
            }
            String username = parameter.get("username")[0];
            String password = parameter.get("password")[0];
            List<User> users = userService.getUserInfoByUserName(username);
            if (CollectionUtils.isEmpty(users)) {
                map.put("result", "failed");
                map.put("msg", "用户名错误");
                return map;
            }
            User user = users.get(0);
            if (!password.equals(user.getPassWord())) {
                map.put("result", "failed");
                map.put("msg", "密码错误");
                return map;
            }
            session.setAttribute(Constants.SESSION + user.getId(), user);
            session.setAttribute(Constants.SESSION_KEY, user);
            map.put("result", "success");
            map.put("msg", "登录成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", "failed");
            map.put("msg", "系统繁忙");
            return map;
        }
    }
}
