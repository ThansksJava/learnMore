package com.learn.concurrent.practice;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Feng Jie
 * @date 2022/3/23 17:44
 */
public class PrintABC {
    static Thread a;
    static Thread b;
    static Thread c;
    public static void main(String[] args) {
        a = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("A");
                LockSupport.unpark(b);
                LockSupport.park();
            }
        },"a");
        b = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.println("B");
                LockSupport.unpark(c);
            }
        },"b");
        c = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.println("C");
                LockSupport.unpark(a);
            }
        },"c");

        a.start();
        b.start();
        c.start();
    }
}
