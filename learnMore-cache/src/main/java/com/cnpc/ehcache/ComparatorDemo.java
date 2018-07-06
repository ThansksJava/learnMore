package com.cnpc.ehcache;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/4
 * @Time 16:12
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("fengjie",18);
        Employee e2 = new Employee("zhaomengjie",16);
        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        System.out.println(list);
        list.sort(Comparator.comparing(Employee::getAge));
        System.out.println(list);
    }
}
