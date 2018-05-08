package com.cnpc.sss.configuration.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/8
 * @Time 15:24
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName())
                    .append(":")
                    .append(method.getName());
            for (Object obj : params) {
                sb.append(":")
                        .append(obj.toString());
            }
            return sb.toString();
        };
    }
}
