package com.learn.concurrent.help;

import lombok.ToString;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/17 20:11
 */
@ToString
public class Person {
    private String name;
    private int old;

    public Person(String name, int old) {
        this.name = name;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public int getOld() {
        return old;
    }
}
