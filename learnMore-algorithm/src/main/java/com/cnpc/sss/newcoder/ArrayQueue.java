package com.cnpc.sss.newcoder;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/30
 * @Time 19:26
 */
public class ArrayQueue {
    private Integer [] space;
    private Integer  size;
    public ArrayQueue(int size){
        if (size < 0){
            throw new IllegalArgumentException("初始化空间不能小于0");
        }
        space = new Integer[size];
        this.size = size;
    }
    public void push(int value){
        if(size == space.length){
            throw new ArrayIndexOutOfBoundsException("Queue full");
        }
        space[--size] = value;
    }
    public Integer pop(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("Queue Empty");
        }
        return space[size++];
    }

}
