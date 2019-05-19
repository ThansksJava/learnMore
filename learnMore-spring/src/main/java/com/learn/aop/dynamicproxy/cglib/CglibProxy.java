package com.learn.aop.dynamicproxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/27
 * @Time 9:56
 */
public class CglibProxy implements MethodInterceptor {
    private Object proxied;
    public CglibProxy(Object proxied){
        this.proxied = proxied;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("==========>代理前执行<==========");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("==========>代理后执行<=========");
        return result;
    }
}
