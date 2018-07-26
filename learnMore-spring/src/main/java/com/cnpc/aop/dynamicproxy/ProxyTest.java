package com.cnpc.aop.dynamicproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/26
 * @Time 14:28
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler() {
    }

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=======被代理对象："+proxy);
        System.out.println("=======被代理对象的方法："+method);
        System.out.println("=======被代理对象的方法参数："+Arrays.toString(args));
        return method.invoke(proxied,args);
    }
}
interface A{
    void doSomething();
}

class AI implements A{
    @Override
    public void doSomething() {
        System.out.println("哈哈哈，在代理后执行了");
    }
}
public class ProxyTest{
    @Test
    public void test(){
        AI ai = new AI();
        A a = (A)(Proxy.newProxyInstance(A.class.getClassLoader(),new Class[]{A.class},new DynamicProxyHandler(ai)));
        a.doSomething();
    }
}