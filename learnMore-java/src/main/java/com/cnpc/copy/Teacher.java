package com.cnpc.copy;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/5 9:30
 */
public class Teacher {
    private String name;
    private String age;

    public Teacher() {
    }

    public Teacher(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
