package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/12 19:14
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudProviderDeptNode1 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderDeptNode1.class,args);
    }
}
