package com.tian.service;

import com.tian.annotation.Service;

/**
 * @auther: lawt
 * @date: 2018/12/15 21
 * @Description: 业务实现类
 */
@Service(IHelloService.class)
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String msg) {
        return msg + "hello world";
    }
}
