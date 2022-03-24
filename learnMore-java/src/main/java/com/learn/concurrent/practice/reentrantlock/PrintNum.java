package com.learn.concurrent.practice.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Feng Jie
 * @date 2022/3/23 17:44
 */
public class PrintNum {
    static int num = 0;
    static ReentrantLock lock = new ReentrantLock();
    static Condition acon = lock.newCondition();
    static Condition bcon = lock.newCondition();
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            lock.lock();
            try {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    bcon.signal();
                    acon.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"a");
        Thread b = new Thread(()->{
            lock.lock();
            try {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    acon.signal();
                    bcon.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"b");

        a.start();
        b.start();
    }
}
