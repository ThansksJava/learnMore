package com.cnpc.aop.dynamicproxy.muiltcglibproxy;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/10/17
 * @Time 15:19
 */
public interface ProxyInterface {
    Object processed(Chain chain);
}
