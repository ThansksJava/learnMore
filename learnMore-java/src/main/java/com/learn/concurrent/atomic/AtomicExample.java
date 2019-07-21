package com.learn.concurrent.atomic;

import com.learn.concurrent.help.Person;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicExample {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
    }
    @Test
    public void atomicInteger() {
        for (int i = 0;i < 10;i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"线程在执行");
                count.incrementAndGet();
                System.out.println(count.get());
            }).start();
        }
    }
    @Test
    public void atomicIntegerArray(){
        int[] value = new int[] { 1, 2 };
        AtomicIntegerArray ai = new AtomicIntegerArray(value);
        //给0位置的数加1
        ai.addAndGet(0,1);
        System.out.println(ai.get(0));
        //0位置依然返回1，因为操作的是value数组的副本
        System.out.println(value[0]);
    }
    @Test
    public void AtomicReference(){
        AtomicReference<Person> atomicUserRef = new AtomicReference<>();
        Person p = new Person("feng",18);
        Person p1 = new Person("feng1",25);
        atomicUserRef.compareAndSet(p,p1);
        System.out.println(p);
    }
}
