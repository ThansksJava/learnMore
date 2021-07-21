package com.learn.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/6/1
 */
public class CallableDemo1 implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("NONONO");
        return "2";
    }
}
