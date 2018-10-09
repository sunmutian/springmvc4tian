package com.tian.springbootdemo.controller;

import com.tian.springbootdemo.dao.domain.Goods;
import com.tian.springbootdemo.service.GoodsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 18
 * @Description: 模拟秒杀
 */
@RestController
public class SecondKillController {
    @Resource
    private GoodsService goodsService;

    /**
     * 秒杀
     * 不采任何锁来实现秒杀
     */
    @PostMapping("/sk1")
    public void secondKill1() {
        Goods goods = goodsService.getUserById(1);
        int count = goods.getCount();
        if (count > 0) {
            //假设每人买一台手机
            goods.setCount(count - 1);
            goodsService.updateUser(goods);
            return;
        }
        System.out.println("未买到商品" + Thread.currentThread().getName());
    }

    /**
     * 秒杀
     * 采用version来实现秒杀
     */
    @PostMapping("/sk2")
    public void secondKill2() {

    }

    /**
     * 秒杀
     * 采用count条件来实现秒杀
     */
    @PostMapping("/sk3")
    public void secondKill3() {

    }

    /**
     * 秒杀
     * 采用memcached条件来实现秒杀
     */
    @PostMapping("/sk4")
    public void secondKill4() {

    }
}
