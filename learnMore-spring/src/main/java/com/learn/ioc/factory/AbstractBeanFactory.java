package com.learn.ioc.factory;

import com.learn.ioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/9
 * @Time 14:54
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 根据名称获得bean
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * bean注册方法
     * @param name
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
    }

    /**
     * 初始化bean，具体实现交给具体的类
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition);

}
