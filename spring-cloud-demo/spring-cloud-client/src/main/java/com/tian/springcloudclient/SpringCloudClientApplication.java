package com.tian.springcloudclient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Spring Cloud Client Application class
 *
 * @author tianwc
 * @date 2018/12/12
 */
@SpringBootApplication
@EnableEurekaServer
@RestController
public class SpringCloudClientApplication {
    @Resource
    private EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientApplication.class, args);
    }

    /**
     * 通过http://localhost:8762/test调用
     */
    @RequestMapping("/test")
    public String testClient() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service-hi", false);
        return instanceInfo.getHomePageUrl();
    }
}
