package com.learn.concurrent.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/6/19
 */
public class ReadWriteTest {
    static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    static Lock r = rw.readLock();
    static Lock w = rw.writeLock();

    public static void main(String[] args) {
        w.lock();
        try{
            r.lock();
        }finally {
            w.unlock();
            r.unlock();
        }
    }
}
