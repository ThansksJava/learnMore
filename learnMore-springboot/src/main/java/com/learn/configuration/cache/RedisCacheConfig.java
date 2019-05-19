package com.learn.configuration.cache;

//import com.learn.sss.mybatis.configuration.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

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
//    @Autowired
//    public void setRedisTemplate(RedisTemplate redisTemplate){
//        RedisCache.setRedisTemplate(redisTemplate);
//    }
}
