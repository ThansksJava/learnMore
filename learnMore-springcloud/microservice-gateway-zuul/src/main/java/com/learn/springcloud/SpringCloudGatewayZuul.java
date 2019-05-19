package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/19 8:40
 */
@SpringBootApplication
@EnableZuulProxy
public class SpringCloudGatewayZuul {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayZuul.class,args);
    }
}
