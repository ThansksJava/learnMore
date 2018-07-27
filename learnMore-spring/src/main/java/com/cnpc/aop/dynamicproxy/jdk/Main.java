package com.cnpc.aop.dynamicproxy.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/26
 * @Time 18:51
 */
public class Main {
    @Test
    public void proxyTest(){
        Impl impl = new Impl();
        Interface  anInterface= (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),new Class[]{Interface.class},new DynamicProxy(impl));

        anInterface.doSomething("吃饭");
    }
}
