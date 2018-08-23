package com.tian;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动服务
 *
 * @author tianweichang
 * @date 2018/08/23
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"/provider.xml"});
        context.start();
        System.out.println("provider success started!");
        System.in.read();
    }
}
