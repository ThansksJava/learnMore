package com.learn.concurrent.reentrantlock;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "enjoy")
public class LockTestCondition {

   static int k=0;

    public static void main(String[] args) {
        waitNofity waitNofity = new waitNofity();

        new Thread(() -> {
            try {
                waitNofity.print(k+"",1,2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();


        new Thread(() -> {
            try {
                waitNofity.print(k+"",2,3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();




        new Thread(() -> {
            try {
                waitNofity.print(k+"",3,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3").start();



    }
        //et t2  t3
        //

    static class waitNofity{
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition con1 = reentrantLock.newCondition();

        int flag=1;

        public void print(String content,int waitFlag,int nextFlag) throws InterruptedException {
            for (int i = 0; i <4 ; i++) {
                reentrantLock.lock();
                try {
                    while (flag!= waitFlag){
                        con1.await();
                    }
                    System.out.print(content);
                    k++;
                    flag= nextFlag;
                    con1.signalAll();
                } finally {
                    reentrantLock.unlock();
                }

            }

        }
    }
}
