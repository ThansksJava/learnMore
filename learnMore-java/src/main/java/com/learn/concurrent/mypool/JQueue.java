package com.learn.concurrent.mypool;

import lombok.extern.slf4j.Slf4j;
import org.junit.internal.runners.statements.RunAfters;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

/**
 * a queue to store task
 * @author fengjie
 * @version 1.0
 * @date 2021/6/26
 */
@Slf4j(topic = "enjoy")
public class JQueue {
    ReentrantLock lock = new ReentrantLock();
    /**
     * queue size
     */
    private int queueSize;
    /**
     * the queue to store size
     */
    private Deque<JRunnable> queue = new ArrayDeque<>();

    public JQueue(int queueSize){
        this.queueSize = queueSize;
    }

    /**
     * define put method to add task to queue
     * @param task
     */
    public void put(JRunnable task){
        /**
         * the size must less than queue size
         */
        if (queue.size() < queueSize){
            queue.add(task);
        }else {
            log.debug("当前队列已满，不能再存放队列");
        }
    }

    /**
     * define get method to get a task
     * 因为是多线程的get应该加锁
     */
    public JRunnable get(){
        lock.lock();
        try{
            if (queue.size() > 0){
               return queue.pop();
            }

        }finally {
            lock.unlock();
        }
        return null;
    }
}
