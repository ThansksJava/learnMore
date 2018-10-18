package com.cnpc.aop.dynamicproxy.muiltcglibproxy;

import java.util.List;

/**
 * @Author fengjie
 * @Description 代理链
 * @Date Created in 2018/10/17
 * @Time 15:14
 */
public class Chain {
    private List<ProxyInterface> list;
    private int index = -1;
    private Object beProxied;

    public Chain(List<ProxyInterface> list, Object beProxied) {
        this.list = list;
        this.beProxied = beProxied;
    }

    public Object processd(){
        Object result;
        if (++index == list.size()) {
            result = (beProxied.toString());
            System.err.println("Target Method invoke result : " + result);
        } else {
            ProxyInterface point = list.get(index);
            result = point.processed(this);
        }
        return result;
    }
}
