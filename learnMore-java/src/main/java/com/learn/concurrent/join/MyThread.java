package com.learn.concurrent.join;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/12/23
 */
public class MyThread extends Thread {
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"开始执行~~~~");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕~~~~");
    }
}
