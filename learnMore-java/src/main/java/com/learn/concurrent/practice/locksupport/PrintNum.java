package com.learn.concurrent.practice.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Feng Jie
 * @date 2022/3/23 17:44
 */
public class PrintNum {
    static Thread a;
    static Thread b;
    static int num = 0;
    public static void main(String[] args) {
        a = new Thread(()->{
            for (;;) {
                System.out.println(Thread.currentThread().getName()+":"+num++);
                LockSupport.unpark(b);
                LockSupport.park();
            }
        },"a");
        b = new Thread(()->{
            LockSupport.park();
            for (; ;) {
                System.out.println(Thread.currentThread().getName()+":"+num++);
                LockSupport.unpark(a);
                LockSupport.park();
            }
        },"b");

        a.start();
        b.start();
    }
}
