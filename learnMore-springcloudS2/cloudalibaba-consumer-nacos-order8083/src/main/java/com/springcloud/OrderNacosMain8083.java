package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Feng Jie
 * @date 2021/11/23 13:55
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosMain8083
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderNacosMain8083.class,args);
    }
}



