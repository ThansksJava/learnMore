package com.learn.concurrent.countdownlatch;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/6/21
 */
@Slf4j(topic = "entertainment")
public class Service {
    static int i = 0;
    @SneakyThrows
    public static void main(String[] args) {

        //定义一个个数为4的计时器
        CountDownLatch ct = new CountDownLatch(4);
        //定义四个人
        ArrayList<String> waiter = new ArrayList<>();
        waiter.add("waiter1");
        waiter.add("waiter2");
        waiter.add("waiter3");
        waiter.add("waiter4");

        ExecutorService executorService = Executors.newFixedThreadPool(4, (r) -> new Thread(r,waiter.get(i++)));
        Random random = new Random();
        for (int j = 0; j < 4; j++) {
            int temp = j;

            executorService.submit(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    for (int k = 0; k < 100; k++) {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(200));
                        String name = Thread.currentThread().getName();
                        name = name + "("+k+")";
                        waiter.set(temp,name);
                        System.out.print("\r"+ Arrays.toString(waiter.toArray()));
                    }
                    ct.countDown();
                }
            });
        }
        ct.await();
        System.out.println("正在接受服务");
        executorService.shutdown();
    }
}
