package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Feng Jie
 * @date 2021/11/15 17:57
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain8080.class,args);
    }
}
