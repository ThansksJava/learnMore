package com.springcloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/19 15:23
 */

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudConfigEurekaClient {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigEurekaClient.class,args);
    }
}
