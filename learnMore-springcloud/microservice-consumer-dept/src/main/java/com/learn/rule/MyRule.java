package com.learn.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义rule，不能跟spring boot application同包
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/15 21:17
 */
@Configuration
public class MyRule {
    @Bean
    public IRule selfRule(){
//        return new RoundRobinRule();
        return new SelfDefineRule();
    }
}
