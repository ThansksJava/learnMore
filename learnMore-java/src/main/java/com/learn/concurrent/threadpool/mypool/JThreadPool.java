package com.learn.concurrent.threadpool.mypool;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/6/26
 */
@Slf4j(topic = "enjoy")
public class JThreadPool {
    /**
     * 存放核心线程
     */
    private Set<Thread> threadSet;
    private int coreSize;
    private JQueue queue;

    /**
     * 定义默认策略
     * @param coreSize
     * @param queueSize
     * @param timeout
     */
    public JThreadPool(int coreSize,int queueSize,int timeout){
        this.coreSize = coreSize;
        threadSet = new HashSet<>();
        queue = new JQueue(queueSize,timeout,(r,t)->{
            r.put(t);
        });
    }
    public JThreadPool(int coreSize,int queueSize,int timeout,PolicyHandler PolicyHandler){
        this.coreSize = coreSize;
        threadSet = new HashSet<>();
        queue = new JQueue(queueSize,timeout,PolicyHandler);
    }

    /**
     * 用来提交线程
     * @param task
     */
    public void submit(JRunnable task){
        //如果核心线程数目仍然有余，那么直接创建新线程并开始运行
        if (threadSet.size() < coreSize){
            JThreadNode jThreadNode = new JThreadNode("JThread-"+(threadSet.size()+1),task,this);
            threadSet.add(jThreadNode);
            jThreadNode.start();

        }else {
            log.debug("当前核心线程已满，task[{}]暂时放到阻塞队列中去",task.getTaskName());
            queue.tryPut(task);
        }
    }

    /**
     * 留一个关闭所有线程的接口
     */
    public void shutdown(){

    }
    public JQueue getQueue() {
        return queue;
    }

    public Set<Thread> getThreadSet() {
        return threadSet;
    }
}
