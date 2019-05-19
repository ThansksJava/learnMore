package com.learn.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/24 11:28
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }
    public static<T> T getBean(Class<T> clazz){
        if(applicationContext == null){
            return null;
        }
        return applicationContext.getBean(clazz);
    }
    public static<T> T getBean(String name,Class<T> clazz){
        if(applicationContext == null){
            return null;
        }
        return applicationContext.getBean(name,clazz);
    }
}
