package com.tian;

import com.tian.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 消费端
 * @author lawt
 */
public class ConsumerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("consumer.xml");
        UserService sayHello = (UserService) ctx.getBean("userService");
        String s = sayHello.getUserById(1111);
        System.out.println(s);
    }
}
