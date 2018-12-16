package com.tian.service;

import com.tian.annotation.Service;

/**
 * @auther: tianweichang
 * @date: 2018/12/15 21
 * @Description:
 */
@Service(IHelloService.class)
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String msg) {
        return "hello world" + msg;
    }
}
