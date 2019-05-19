package com.springcloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/19 15:23
 */

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfigDeptClient {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigDeptClient.class,args);
    }
}
