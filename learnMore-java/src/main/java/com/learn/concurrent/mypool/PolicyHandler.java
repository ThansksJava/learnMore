package com.learn.concurrent.mypool;



/**
 * 策略
 * @author fengjie
 * @version 1.0
 * @date 2021/6/26
 */
public interface PolicyHandler {
    /**
     * 定义一个策略，决定是丢弃还是其他处理
     * @param queue
     * @param task
     */
    void handler(JQueue queue,JRunnable task) throws Exception;
}
