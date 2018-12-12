package com.tian.springcloudclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClientApplication.class, args);
	}
}
