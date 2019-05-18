package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/12 20:00
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.learn.springcloud"})
@ComponentScan("com.learn.springcloud")
public class SpringCloudConsumerDeptFeignHystrix {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerDeptFeignHystrix.class,args);
    }
}
