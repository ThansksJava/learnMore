package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Feng Jie
 * @date 2021/11/15 13:21
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain8080.class,args);
    }
}
