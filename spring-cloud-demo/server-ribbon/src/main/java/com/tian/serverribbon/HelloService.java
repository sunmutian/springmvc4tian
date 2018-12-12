package com.tian.serverribbon;

import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public class HelloService {
    @Resource
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
}
