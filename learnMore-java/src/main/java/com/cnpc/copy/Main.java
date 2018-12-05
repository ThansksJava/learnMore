package com.cnpc.copy;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/5 9:35
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Teacher teacher = new Teacher("cls","30");
        Student student = new Student("fengjie","24",teacher);
        Student cloneStudent  = (Student) student.clone();
        System.out.println(student);
        System.out.println(cloneStudent);
    }
}
