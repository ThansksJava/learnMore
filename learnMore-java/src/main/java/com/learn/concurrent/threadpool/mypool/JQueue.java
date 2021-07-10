package com.learn.concurrent.threadpool.mypool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
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
    Condition waitGet = lock.newCondition();
    Condition waitPut = lock.newCondition();
    int timeout;
    PolicyHandler policyHander;
    /**
     * queue size
     */
    private int queueSize;
    /**
     * the queue to store size
     */
    private Deque<JRunnable> queue = new ArrayDeque<>();

    public JQueue(int queueSize, int timeout,PolicyHandler policyHander){
        this.queueSize = queueSize;
        this.timeout = timeout;
        this.policyHander = policyHander;
    }

    /**
     * define put method to add task to queue
     * 注意：是主线程往里放，阻塞的也是主线程
     * @param task
     */
    public void put(JRunnable task){
        lock.lock();
        try {
            if(queue.size() == queueSize){
                log.debug("当前队列已满，不能再存放队列，阻塞task[{}]放入，直到queue 被get后解除阻塞",task.getTaskName());
                try {
                    waitGet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("当前队列还有余位队列，放入task[{}]",task.getTaskName());
            queue.addLast(task);
            waitPut.signal();
        }finally {
            lock.unlock();
        }

    }
    /**
     * 指定超时时间
     * @param task
     */
    public void tryPut(JRunnable task){
        lock.lock();
        try {
            while(queue.size() == queueSize){
                try {
                    policyHander.handler(this,task);
                    log.debug("当前队列已满task[{}]",task.getTaskName());
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            log.debug("当前队列还有余位队列，放入task[{}]",task.getTaskName());
            queue.addLast(task);
            waitPut.signal();
        }finally {
            lock.unlock();
        }

    }
    /**
     * define get method to get a task
     * 因为是多线程的get应该加锁
     * 如果空了的话阻塞
     */
    public JRunnable get(){
        lock.lock();
        try{
            //如果没有别的任务再put，最后一个执行完毕后唤醒，使用if那么唤醒以后就继续往后执行就空指针了
            while (queue.isEmpty()){
                log.debug("队列为空，应该阻塞");
                waitPut.await();
            }
            log.debug("当前队列可以取出task");
            JRunnable task = queue.removeFirst();
            waitGet.signal();
            return task;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
    /**
     * 超时取,设置为1000纳秒
     */
    public JRunnable getTimeout(){
        lock.lock();
        try{
            //如果没有别的任务再put，最后一个执行完毕后唤醒，使用if那么唤醒以后就继续往后执行就空指针了
            long leftTimeout= 0;
            while (queue.isEmpty()){
                if(leftTimeout <= 0){
                    return null;
                }
                log.debug("队列为空，应该阻塞");
                leftTimeout = waitPut.awaitNanos(1000);
            }
            log.debug("当前队列可以取出task");
            JRunnable task = queue.removeFirst();
            waitGet.signal();
            return task;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
