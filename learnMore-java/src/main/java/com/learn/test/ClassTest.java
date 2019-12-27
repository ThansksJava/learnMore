package com.learn.test;

import java.io.File;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/10/26
 * @Time 10:34
 */
public class ClassTest {
    static class DeadLoolClass{
        static {
            System.out.println(Thread.currentThread()+"init");
        }
    }

    public static void main(String[] args) {
//        Runnable test = () -> {
//            System.out.println(Thread.currentThread()+"start");
//            DeadLoolClass deadLoolClass = new DeadLoolClass();
//            System.out.println(Thread.currentThread()+"end");
//        };
//        Thread t1 = new Thread(test);
//        Thread t2 = new Thread(test);
//        t1.start();
//        t2.start();
        String path = "C:\\var\\log\\x";
        int i = path.lastIndexOf("\\");
        int j = path.lastIndexOf(File.separator);
        System.out.println("\\");
        System.out.println(i);
        System.out.println(j);
    }
}
