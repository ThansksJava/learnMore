package com.learn.concurrent.join;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/12/23
 */
public class Main {
    public static void joinTest() {
        for(int i = 0;i < 5;i++){
            MyThread thread = new MyThread();
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main thread execute finish");
    }

    /**
     * failure
     */
    public static  void myJoinTest() {
        for(int i = 0;i < 5;i++){

            MyThread thread = new MyThread();
            thread.start();

        }
        System.out.println("main thread execute finish");
    }

    public static void main(String[] args) {
        joinTest();
    }
}
