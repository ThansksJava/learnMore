package com.learn.concurrent.reentrantlock;

import com.learn.concurrent.waitnotifysleep.NotifyTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/12/23
 */
public class ReentranLockTest1 {
    private Lock lock = new ReentrantLock(true);
    public void testReentrant(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() +" Start-----");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +" End-------");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReentranLockTest1 test = new ReentranLockTest1();
        for(int i=0;i<5;i++) {
            new Thread(() -> test.testReentrant()).start();
        }
    }
}
