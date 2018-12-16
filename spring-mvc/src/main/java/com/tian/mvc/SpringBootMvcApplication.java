package com.tian.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther: tianweichang
 * @date: 2018/12/9 17
 * @Description:
 */
@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootMvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcApplication.class, args);
    }
}
