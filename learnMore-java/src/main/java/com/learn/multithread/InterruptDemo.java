package com.learn.multithread;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/25 23:08
 */
public class InterruptDemo {
    public static void main(String[] args) {
        new Thread(()->{
            while(!Thread.interrupted()){
                System.out.println("检测到中断标志结束线程运行");break;
            }
            Thread.currentThread().isInterrupted();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.currentThread().interrupt();
        }).start();
    }
}
