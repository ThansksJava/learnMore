package com.learn.concurrent.threadpool.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/6/27
 */
@Slf4j(topic = "enjoy")
public class ThreadPoolExecutorTest1 {
    public static void main(String[] args) {
        ThreadPoolExecutor t1 = new ThreadPoolExecutor(2,3,3, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1),(r,e)->{
            log.debug("进来一个新线程",r);

        });
        t1.execute(()->{
            log.debug("hello world1");
            try {
                TimeUnit.SECONDS.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.execute(()->{
            log.debug("hello world2");
            try {
                TimeUnit.SECONDS.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.execute(()->{
            log.debug("hello world3");
            try {
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.execute(()->{
            log.debug("hello world4");
            try {
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.execute(()->{
            log.debug("hello world5");
            try {
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.execute(()->{
            log.debug("hello world6");
            try {
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (int i = 0; i < 20; i++) {
            log.debug("PoolSize:"+t1.getPoolSize());
        }

    }
}
