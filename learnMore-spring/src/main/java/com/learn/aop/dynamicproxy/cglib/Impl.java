package com.learn.aop.dynamicproxy.cglib;

import com.learn.aop.dynamicproxy.jdk.Interface;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/26
 * @Time 18:50
 */
public class Impl implements Interface {
    @Override
    public void doSomething(String action) {
        System.out.println("《《《《我是被代理的类的方法，"+action+"正在执行中》》》》");
    }
}
