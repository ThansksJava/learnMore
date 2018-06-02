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
    private Integer start;
    private Integer end;
    public ArrayQueue(int size){
        if (size < 0){
            throw new IllegalArgumentException("初始化空间不能小于0");
        }
        space = new Integer[size];
        this.size = 0;
        this.start = 0;
        this.end = 0;
    }
    public void push(int value){
        if(size == space.length){
            throw new ArrayIndexOutOfBoundsException("Queue full");
        }
        size++;
        space[end] = value;
        /*如果end的值指向数组末尾，那么数组已经满了，得重新从头开始放，当然必须先pop数，否则就一直卡在异常的位置*/
        end = end == space.length - 1?0:end+1;

    }
    public Integer pop(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("Queue Empty");
        }
        int popValue;
        /*将数组中数量减一*/
        size--;
        /*弹出值*/
        popValue = space[start];
        start = start == space.length?0:start+1;
        return popValue;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.push(4);
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
    }

}
