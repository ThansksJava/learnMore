package com.learn.concurrent.waitnotifysleep;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/12/23
 */
public class WaitTest {

    public void wrongTestWait(){
        System.out.println("Start-----");
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End-------");
    }
    public synchronized void testWait(){
        System.out.println("Start-----");
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End-------");
    }
    public static void main(String[] args) {
        final WaitTest test = new WaitTest();
        new Thread(() -> test.testWait()).start();
    }
}