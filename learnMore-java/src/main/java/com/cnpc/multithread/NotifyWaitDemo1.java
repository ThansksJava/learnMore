package com.cnpc.multithread;

/**
 * 基本用法
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/23 19:35
 */
public class NotifyWaitDemo1 {
    public synchronized void method1(){
        try {
            System.out.println(Thread.currentThread().getName()+"开始wait");
            this.wait();
            System.out.println(Thread.currentThread().getName()+"结束wait");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void method2(){
        try {
            System.out.println(Thread.currentThread().getName()+"开始执行唤醒");
            this.notify();
            System.out.println(Thread.currentThread().getName()+"执行唤醒");
            //虽然notify方法已经执行完毕，但是此时线程2还持有本对象锁，等待的线程1依然不能拿到锁继续执行
            Thread.sleep(5000);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NotifyWaitDemo1 demo1 = new NotifyWaitDemo1();
        new Thread(()->{
            demo1.method1();
        }).start();
        new Thread(()->{
            demo1.method2();
        }).start();
    }
}
