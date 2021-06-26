package com.learn.concurrent.mypool;

import lombok.extern.slf4j.Slf4j;

/**
 * v1.1 add a queue to store task that need to wait
 * @author fengjie
 * @version 1.0
 * @date 2021/6/26
 */
@Slf4j(topic = "enjoy")
public class JPoolTest {
    public static void main(String[] args) throws InterruptedException {
        int coreSize = 2;
        int queueSize = 3;
        JThreadPool jThreadPool = new JThreadPool(coreSize,queueSize);
        for (int tn = 1; tn <= 7; tn++) {
            int finalTn = tn;
            jThreadPool.submit(new JRunnable("task-"+finalTn));
        }

        log.debug("main thread...");
    }
}
