package com.learn.test;


import lombok.*;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/1/11 14:42
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Person {
    private boolean used;
    private String name;
    private String age;
}
