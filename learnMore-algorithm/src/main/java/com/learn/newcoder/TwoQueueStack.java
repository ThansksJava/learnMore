package com.learn.newcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/6/2
 * @Time 17:12
 */
public class TwoQueueStack {
    Queue<Integer> data;
    Queue<Integer> help;
    public TwoQueueStack(){
        data = new LinkedList<>();
        help = new LinkedList<>();
    }
    public void push(int value){
        data.add(value);
    }
    public int pop(){
        int size = data.size();
        for(int i = 0;i < size-1;i++){
            help.add(data.poll());
        }
        int val = data.poll();
        swap();
        return val;
    }
    private void swap() {
        Queue<Integer> tmp = help;
        help = data;
        data = tmp;
    }

}
