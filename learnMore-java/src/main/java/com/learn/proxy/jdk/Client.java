package com.learn.proxy.jdk;

/**
 * @author: 乔利强
 * @date: 2020/12/11 19:55
 * @description:
 */
public class Client {

    public static void main(String[] args) {
        // 目标对象
        UserDao target = new UserDao();
        // class aop.UserDao
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        proxy.save();

        System.out.println("===1===");

        proxy.delete();

        System.out.println("===2===");

        proxy.saveAndDelete();
    }
}