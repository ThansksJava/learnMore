package com.cnpc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/8/24
 * @Time 11:26
 */
public class Counter {
    private Lock lock = new ReentrantLock();
    private StringBuilder sql = new StringBuilder();
}
