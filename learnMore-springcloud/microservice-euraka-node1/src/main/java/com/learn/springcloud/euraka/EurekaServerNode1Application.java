package com.learn.springcloud.euraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EnableEurekaServer表示这是Eureka注册中心
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/13 19:29
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerNode1Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerNode1Application.class,args);
    }
}
