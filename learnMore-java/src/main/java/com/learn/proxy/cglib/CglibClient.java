package com.learn.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author: 乔利强
 * @date: 2020/12/11 20:07
 * @description:
 */
public class CglibClient {

    public static void main(String[] args) {
        //在指定目录下生成动态代理类，我们可以反编译看一下里面到底是一些什么东西
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "G:/proxy");

        CglibProxyFactory cglibProxy = new CglibProxyFactory();
        //jdk需要提供接口，cglib需要是非私有类，且不能处理final关键字修饰的方法
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(UserDao.class);
        //设置回调对象
        enhancer.setCallback(cglibProxy);

        UserDao proxy = (UserDao) enhancer.create();
        proxy.save();

        System.out.println("===1===");

        proxy.delete();

        System.out.println("===2===");

        proxy.saveAndDelete();
    }
}