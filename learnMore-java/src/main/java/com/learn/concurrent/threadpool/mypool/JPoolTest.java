package com.learn.concurrent.threadpool.mypool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionException;

/**
 * v3 空闲线程
 * @author fengjie
 * @version 1.0
 * @date 2021/6/26
 */
@Slf4j(topic = "enjoy")
public class JPoolTest {
    public static void main(String[] args) throws InterruptedException {
        int coreSize = 2;
        int queueSize = 3;
        int timeout = 1000;
        JThreadPool jThreadPool = new JThreadPool(coreSize,queueSize,timeout,(q,t)->{
            throw new RejectedExecutionException("不支持这么多任务");
        });
        for (int tn = 1; tn <= 7; tn++) {
            int finalTn = tn;
            jThreadPool.submit(new JRunnable("task-"+finalTn));
        }

        log.debug("main thread...");
    }
}
