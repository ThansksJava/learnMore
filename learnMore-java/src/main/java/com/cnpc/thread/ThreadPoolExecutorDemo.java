package com.cnpc.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/2/27 14:16
 */
@Slf4j
public class ThreadPoolExecutorDemo {
    private static int n = 0;
    static ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("fengjie").build();
    static ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,5000,
            TimeUnit.MILLISECONDS, queue,factory);
    private void execute(){
        for(int i = 0;i < 10;i++){
            executor.execute(() -> {
                n++;
                System.out.println("n="+n);
            });
            System.out.println("i="+i);
        }
        System.out.println("正在执行中");
        executor.shutdown();
    }

    public static void main(String[] args) {
        new ThreadPoolExecutorDemo().execute();
    }

}
