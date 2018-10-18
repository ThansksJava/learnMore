package com.cnpc.aop.dynamicproxy.muiltcglibproxy;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/10/18
 * @Time 9:37
 */
public class Main {
    public static void main(String[] args) {
        ProxyFactory.create().getProxy(new BeProxiedClass()).toString();
    }
}
