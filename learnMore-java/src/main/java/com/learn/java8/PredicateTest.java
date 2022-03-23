package com.learn.java8;

import java.util.function.Predicate;

/**
 * @author Feng Jie
 * @date 2021/12/27 11:39
 */
public class PredicateTest {
    public static void main(String[] args) {
        Apple red = new Apple(1, "red");
        Predicate<Apple> redApple = apple -> apple.getColor().equals("red");
        Predicate<Apple> notRedApple = redApple.negate();
        boolean test = redApple.test(red);
        System.out.println(test);

    }
}
