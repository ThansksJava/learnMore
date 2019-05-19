package com.learn.ioc;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/9
 * @Time 14:33
 */
public class BeanDefinition {
    private Object bean;

    private Class beanClass;

    private String beanClassName;
    /**
     * 属性注入
     */
    private PropertyValues propertyValues;

    public BeanDefinition() {
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass(){
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    /**
     * 通过反射机制获取bean
     * @param beanClassName
     */
    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try{
            /*反射获得bean,此处需要注入类全名称 包名+类名*/
            this.beanClass = Class.forName(beanClassName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Object getBean() {
        return bean;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
