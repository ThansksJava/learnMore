package com.cnpc.aop.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
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
        //创建代理增强器
        Enhancer enhancer = new Enhancer();
        //指定要增强的类
        enhancer.setSuperclass(impl.getClass());
        //设置回调，被代理的类的所有方法都会经过代理
        enhancer.setCallback(new CglibProxy(impl));
        Impl impl1 = (Impl)enhancer.create();
        impl1.doSomething("喝酒");
    }
}
