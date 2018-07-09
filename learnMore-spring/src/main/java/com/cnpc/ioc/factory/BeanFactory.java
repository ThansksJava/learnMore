package com.cnpc.ioc.factory;

import com.cnpc.ioc.BeanDefinition;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/9
 * @Time 14:33
 */
public interface BeanFactory {
    Object getBean(String name);
    void registerBeanDefinition(String name,BeanDefinition beanDefinition);
}
