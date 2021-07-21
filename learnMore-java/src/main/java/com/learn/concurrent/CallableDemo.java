package com.learn.concurrent;

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
public class CallableDemo implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> f = executorService.submit(new CallableDemo());
        Future<String> f1 = executorService.submit(new CallableDemo1());
        executorService.shutdown();
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(4000);
        System.out.println("哈哈哈");
        return "1";
    }
}
