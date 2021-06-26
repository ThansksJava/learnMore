package com.learn.concurrent.mypool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * mainly give a name to task.
 * @author fengjie
 * @version 1.0
 * @date 2021/6/26
 */
@Slf4j(topic = "enjoy")
public class JRunnable implements Runnable{
    private String taskName;
    public JRunnable(String taskName){
        this.taskName = taskName;
    }
    //目前啥也不干，就打印一下就行
    @Override
    public void run() {
        try {
            log.debug("当前正在运行的任务是task[{}]",taskName);
            TimeUnit.MILLISECONDS.sleep(2000);
            log.debug("task[{}]执行完毕",taskName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
