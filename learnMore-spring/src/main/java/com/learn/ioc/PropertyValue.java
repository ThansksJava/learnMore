package com.learn.ioc;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/9
 * @Time 19:42
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
