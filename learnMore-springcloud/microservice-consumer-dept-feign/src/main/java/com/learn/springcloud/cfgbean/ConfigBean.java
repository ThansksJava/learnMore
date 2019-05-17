package com.learn.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/12 19:44
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
    @Bean
    IRule myRule(){
        return new RandomRule();
    }
}
