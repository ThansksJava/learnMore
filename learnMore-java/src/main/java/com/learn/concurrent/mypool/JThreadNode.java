package com.learn.concurrent.mypool;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;

/**
 * this class extends the Thread class, give it a name and override the run
 * @author fengjie
 * @version 1.0
 * @date 2021/6/26
 */
@Slf4j(topic = "enjoy")
public class JThreadNode extends Thread{
    private JRunnable task;
    private JQueue queue;
    public JThreadNode(String name,JRunnable task,JQueue queue){
        setName(name);
        this.task = task;
        this.queue = queue;
    }
    @Override
    public void run() {
        log.debug("Thread:"+Thread.currentThread().getName()+"开始运行");
        //if the task is not null or we can get a task,the thread will keep alive
        while(task != null || (task = queue.get()) != null){
            log.debug("Thread:"+Thread.currentThread().getName()+"正在执行task[{}]",task.getTaskName());
            task.run();
            task = null;
        }
        log.debug("Thread:"+Thread.currentThread().getName()+"结束运行");
    }
}
