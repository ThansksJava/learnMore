package com.cnpc.sss.newcoder;
/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/29
 * @Time 19:36
 */
public class ArrayStack {
    private Integer [] space;
    private Integer size;
    public ArrayStack(int size){
        if (size < 0){
            throw new IllegalArgumentException("初始化空间不能小于0");
        }
        space = new Integer[size];
        this.size = 0;
    }
    public void push(int value){
        if(size == space.length){
            throw new ArrayIndexOutOfBoundsException("stack full");
        }
        space[size++] = value;
    }
    public int pop(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("stack empty");
        }
        return space[--size];
    }
    public Integer peek(){
        if(size == 0){
            return null;
        }
        return space[size-1];
    }
}
