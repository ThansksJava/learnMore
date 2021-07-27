package com.learn.proxy.fatherandson;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/7/16
 */
public class Father {
    public void eat(){
        System.out.println("father eat");
    }
    public void drink(){
        System.out.println("father drink");
    }

    public void live(){
        eat();
        drink();
    }
}
