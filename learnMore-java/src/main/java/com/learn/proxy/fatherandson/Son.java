package com.learn.proxy.fatherandson;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/7/16
 */
public class Son extends Father{
    @Override
    public void eat() {
        System.out.println("son eat");
    }

    @Override
    public void drink() {
        System.out.println("son drink");
    }

    @Override
    public void live() {
        super.live();
    }


    public static void main(String[] args) {
        Son son = new Son();
        son.live();
    }
}
