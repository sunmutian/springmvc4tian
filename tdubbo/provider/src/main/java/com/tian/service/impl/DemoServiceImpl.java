package com.tian.service.impl;

import com.tian.service.DemoService;

/**
 * 服务实现类
 *
 * @author tianweichang
 * @date 2018-08-23 15:34
 **/
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String msg) {
        System.out.println("==========msg:" + msg);
        return "say:" + msg;
    }
}
