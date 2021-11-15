package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Feng Jie
 * @date 2021/11/12 14:41
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class OrderConsulMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain8080.class,args);
    }
}
