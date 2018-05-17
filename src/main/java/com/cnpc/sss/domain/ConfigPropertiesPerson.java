package com.cnpc.sss.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/17
 * @Time 10:40
 */
@ConfigurationProperties(prefix = "person")
public class ConfigPropertiesPerson {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
