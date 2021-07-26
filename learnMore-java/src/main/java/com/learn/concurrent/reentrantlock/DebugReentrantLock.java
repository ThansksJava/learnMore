package com.learn.concurrent.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 设置线程级别的断点
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/7/26
 */
@Slf4j(topic = "enjoy")
public class DebugReentrantLock {
    static final ReentrantLock lock = new ReentrantLock(true);
    public static void main(String[] args) {
        new Thread(()->{
            try {
                lock.lock();

                log.debug(Thread.currentThread().getName()+"start execute");
            } finally {
                lock.unlock();
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            try {
                lock.lock();
                log.debug(Thread.currentThread().getName()+"start execute");
            } finally {
                lock.unlock();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            try {
                lock.lock();
                log.debug(Thread.currentThread().getName()+"start execute");
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
