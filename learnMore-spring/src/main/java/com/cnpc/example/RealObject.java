package com.cnpc.example;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/26
 * @Time 20:04
 */
public class RealObject implements Interface {
    @Override
    public void getMyName() {
        System.out.println("my name is huhx");
    }

    @Override
    public String getNameById(String id) {
        System.out.println("argument id: " + id);
        return "huhx";
    }
}