package com.learn.springcloud;

import com.learn.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/12 20:00
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservice-dept",configuration = MyRule.class)
public class SpringCloudConsumerDept {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerDept.class,args);
    }
}
