package com.cnpc.ioc.factory;

import com.cnpc.ioc.BeanDefinition;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/9
 * @Time 15:15
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            /*反射得到类的对象*/
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
