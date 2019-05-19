package com.learn.copy;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/5 9:35
 */
public class Main {
    public static void main(String[] args) throws Exception{
        //浅克隆
//        qclone();
        //深克隆
        sclone();

    }
    public static void qclone() throws Exception{
        Teacher teacher = new Teacher("cls","30");
        Student student = new Student("fengjie","24",teacher);
        Student cloneStudent  = (Student) student.clone();
        System.out.println(student);
        System.out.println(cloneStudent);
    }
    public static void sclone() throws Exception{
        Teacher1 teacher = new Teacher1("cls","30");
        Student1 student = new Student1("fengjie","24",teacher);
        Student1 cloneStudent  = (Student1) student.clone();
        System.out.println(student);
        System.out.println(cloneStudent);
    }
}
