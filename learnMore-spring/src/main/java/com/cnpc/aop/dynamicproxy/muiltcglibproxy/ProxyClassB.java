package com.cnpc.aop.dynamicproxy.muiltcglibproxy;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/10/17
 * @Time 15:15
 */
public class ProxyClassB implements ProxyInterface {
    @Override
    public Object processed(Chain chain) {
        try{
            System.out.println("point 2 before");
            Thread.sleep(20);
            Object result = chain.processd();
            Thread.sleep(20);
            System.out.println("point 2 after");
            return result;
        }catch (Exception e){

        }
        return null;
    }
}
