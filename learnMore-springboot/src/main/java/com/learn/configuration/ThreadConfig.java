package com.learn.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/1/29 15:51
 */
@ConfigurationProperties("task.pool")
public class ThreadConfig {
    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;
}
