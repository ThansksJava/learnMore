package com.cnpc.aop;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/30
 * @Time 14:27
 */
public class Child extends Parent{
    void childM(){
        System.out.println(this.getClass());
    }

    public static void main(String[] args) {
        Parent p = new Child();
        Parent parent = new Parent();
        parent.parentM();
        p.parentM();
//        ((Child) p).childM();
    }
}
