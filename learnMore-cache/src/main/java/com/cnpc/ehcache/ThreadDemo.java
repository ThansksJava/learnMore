package com.cnpc.ehcache;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/4
 * @Time 11:25
 */
public class ThreadDemo implements Runnable {
    @Override
    public void run() {
        int i = 1;
        while(true){
            System.out.println("第" + i++ +"次");
        }
    }

    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        new Thread(t).start();
    }
}
