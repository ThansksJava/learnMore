package com.learn.concurrent.mypool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/6/26
 */
@Slf4j(topic = "enjoy")
public class JPoolTest {
    public static void main(String[] args) throws InterruptedException {
        int coreSize = 2;
        JThreadPool jThreadPool = new JThreadPool(coreSize);
        for (int tn = 0; tn < 3; tn++) {
            int finalTn = tn;
            jThreadPool.submit(()->{
                log.debug("正在执行task[{}]",finalTn);
            });
        }

        log.debug("main thread...");
    }
}
