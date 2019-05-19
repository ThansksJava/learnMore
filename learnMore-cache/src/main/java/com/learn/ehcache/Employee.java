package com.learn.ehcache;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/4
 * @Time 16:12
 */
public class Employee {
    private String name;
    private int age;
    public Employee(String name,int age){
        this.name=name;
        this.age=age;
    }

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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
