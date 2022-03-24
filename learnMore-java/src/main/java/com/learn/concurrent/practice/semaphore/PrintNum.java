package com.learn.concurrent.practice.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Feng Jie
 * @date 2022/3/23 17:44
 */
public class PrintNum {
    static int num = 0;
    static Semaphore sa = new Semaphore(1);
    static Semaphore sb = new Semaphore(0);
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            try {
                while (true) {
                    sa.acquire();
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    sb.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
        },"a");
        Thread b = new Thread(()->{
            try {
                while (true) {
                    sb.acquire();
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    sa.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
        },"b");

        a.start();
        b.start();
    }
}
