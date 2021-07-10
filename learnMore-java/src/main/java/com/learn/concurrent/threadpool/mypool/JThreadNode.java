package com.learn.concurrent.threadpool.mypool;

import lombok.extern.slf4j.Slf4j;

/**
 * this class extends the Thread class, give it a name and override the run
 * @author fengjie
 * @version 1.0
 * @date 2021/6/26
 */
@Slf4j(topic = "enjoy")
public class JThreadNode extends Thread{
    private JRunnable task;
    private JThreadPool jThreadPool;
    public JThreadNode(String name,JRunnable task,JThreadPool jThreadPool){
        setName(name);
        this.task = task;
        this.jThreadPool = jThreadPool;
    }
    @Override
    public void run() {
        JQueue queue = jThreadPool.getQueue();
        log.debug("创建Thread:"+Thread.currentThread().getName());
        //if the task is not null or we can get a task,the thread will keep alive
        while(task != null || (task = queue.get()) != null){
            log.debug(""+Thread.currentThread().getName()+"正在执行task[{}]",task.getTaskName());
            task.run();
            task = null;
        }
        log.debug(""+Thread.currentThread().getName()+"结束运行");
        jThreadPool.getThreadSet().remove(this);
    }
}
