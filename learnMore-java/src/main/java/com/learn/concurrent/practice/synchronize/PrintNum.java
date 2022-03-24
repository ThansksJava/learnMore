package com.learn.concurrent.practice.synchronize;

import cn.hutool.crypto.GlobalBouncyCastleProvider;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Feng Jie
 * @date 2022/3/23 17:44
 */
public class PrintNum {
    static int num = 0;
    static boolean flaga = true;
    static boolean flagb = false;
    static Object lock = new Object();
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            synchronized (lock) {
                while (true) {
                    if (flaga) {
                        System.out.println(Thread.currentThread().getName() + ":" + num++);
                        flaga = false;
                        flagb = true;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"a");
        Thread b = new Thread(()->{
            synchronized (lock) {
                while (true) {
                    if (flagb) {
                        System.out.println(Thread.currentThread().getName() + ":" + num++);
                        flagb = false;
                        flaga = true;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"b");

        a.start();
        b.start();
    }
}
