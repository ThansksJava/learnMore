package com.cnpc.copy;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/5 9:31
 */
public class Student1 implements Cloneable{
    private String name;
    private String age;
    private Teacher1 teacher;

    public Student1() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Student1(String name, String age, Teacher1 teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
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

    public Teacher1 getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher1 teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
