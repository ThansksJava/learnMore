package com.cnpc.aop.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/26
 * @Time 18:43
 */
public class DynamicProxy implements InvocationHandler {
    //被代理的类
    private Object proxied;
    //构造函数中注入被代理的类
    public DynamicProxy(Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy="+proxy.getClass()+",method="+method.getName()+",args="+Arrays.toString(args));
        System.out.println("=========》被代理类方法执行前执行内容《==========");
        Object result = method.invoke(proxied,args);
        System.out.println("=========》被代理类方法执行后执行内容《==========");
        return result;
    }
}
