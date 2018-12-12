package com.tian.spring.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tian.spring.mvc.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * ClassName:StudentController
 * Date:     2017年11月6日 下午4:27:40
 *
 * @author Joe
 * @since JDK 1.8
 */
@Controller
public class IndexController {
    @Resource
    private ArticleService articleService;

    /**
     * freemarker:(跳转到 freemarker.ftl).
     *
     * @param map
     * @return
     * @author Joe
     * Date:2017年11月6日下午4:52:19
     */
    @RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> map) {
        map.put("name", "Joe");
        //sex:性别，1：男；0：女；
        map.put("sex", 1);

        // 模拟数据
        List<Map<String, Object>> friends = new ArrayList<>();
        Map<String, Object> friend = new HashMap<>();
        friend.put("name", "xbq");
        friend.put("age", 22);
        friends.add(friend);
        friend = new HashMap<>();
        friend.put("name", "July");
        friend.put("age", 18);
        friends.add(friend);
        map.put("friends", friends);
        return "freemarker";
    }

    @RequestMapping("/index")
    public String index(HttpSession session, Model model) {
        // 模拟数据
        List<Map<String, Object>> friends = new ArrayList<>();
        Map<String, Object> friend = new HashMap<>();
        friend.put("name", "xbq");
        friend.put("age", 22);
        friends.add(friend);
        friend = new HashMap<>();
        friend.put("name", "July");
        friend.put("age", 18);
        friends.add(friend);
        model.addAttribute("friends", friends);
        int userId = 1;
        if (session != null) {
            userId = 0;
        }
        int countArticles = articleService.selectCountByUserId(userId);
        model.addAttribute("countArticles", countArticles);
        model.addAttribute("days", 120);
        model.addAttribute("content", "敬请期待");
        model.addAttribute("title", "hello world");
        model.addAttribute("email", "251965157@qq.com");
        model.addAttribute("wechat", "Java后端技术栈");
        return "index";
    }
}
