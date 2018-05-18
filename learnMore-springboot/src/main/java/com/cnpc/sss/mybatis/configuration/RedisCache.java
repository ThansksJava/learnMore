package com.cnpc.sss.mybatis.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/17
 * @Time 14:07
 */

public class RedisCache implements Cache {
    private static final Log logger = LogFactory.getLog(RedisCache.class);
    private static RedisTemplate redisTemplate;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final String id;
    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("缓存没有初始化id");
        }
        logger.debug("==================MyBatisRedisCache:id=" + id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
        redisTemplate.opsForValue().set(serializer.serialize(key), serializer.serialize(value));
    }

    @Override
    public Object getObject(Object key) {
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    public static void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.redisTemplate = redisTemplate;
    }
}
