package com.learn.aop.dynamicproxy.muiltcglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/10/17
 * @Time 15:13
 */
public class ProxyFactory {
    private ProxyFactory(){}
    public static ProxyFactory create(){
        return new ProxyFactory();
    }
    public Object getProxy(Object beProxied){
        final Enhancer en = new Enhancer();
        en.setSuperclass(beProxied.getClass());
        List<ProxyInterface> proxyList = new ArrayList<>();
        proxyList.add(new ProxyClassA());
        proxyList.add(new ProxyClassB());
        en.setCallback(new Intercepter(new Chain(proxyList,beProxied)));
        return en.create();
    }
    private class Intercepter implements MethodInterceptor{
        Chain chain;
        public Intercepter(Chain chain){
            this.chain = chain;
        }
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            return chain.processd();
        }
    }
}
