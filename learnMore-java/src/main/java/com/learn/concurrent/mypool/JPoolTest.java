package com.learn.concurrent.mypool;

import lombok.extern.slf4j.Slf4j;

/**
 * this version only can submit a task and create a thread to execute it,one task one thread,
 * if the thread num is less than core thread size
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
