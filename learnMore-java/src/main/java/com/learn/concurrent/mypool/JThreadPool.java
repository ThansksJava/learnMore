package com.learn.concurrent.mypool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/6/26
 */
public class JThreadPool {
    /**
     * 存放核心线程
     */
    Set<Thread> threadSet;
    int coreSize;
    public JThreadPool(int coreSize){
        this.coreSize = coreSize;
        threadSet = new HashSet<>();
    }

    /**
     * 用来提交线程
     * @param task
     */
    public void submit(Runnable task){
        if (threadSet.size() < coreSize){
            Thread t = new Thread(task);
            threadSet.add(t);
            t.start();
        }
    }
}
