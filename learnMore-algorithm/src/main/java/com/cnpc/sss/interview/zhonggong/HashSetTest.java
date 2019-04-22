package com.cnpc.sss.interview.zhonggong;

import java.util.HashSet;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/9 20:55
 */
public class HashSetTest {
    static class Person{
        protected String name;
        protected int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this){
                return true;
            }
            if(!(obj instanceof Person)){
                return false;
            }
            Person person = (Person)obj;
            return person.name.equals(this.name) && person.age==this.age;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + name.hashCode();
            result = result * 31 + age;
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
    static class Person1 implements Comparable{
        protected String name;
        protected String age;

        public Person1(String name, String age) {
            this.name = name;
            this.age = age;
        }


        @Override
        public int compareTo(Object o) {
            Person1 person = (Person1)o;
            return (person.name ==  this.name && person.age == this.age) ? 0:1;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person("fengjie",18);
        Person p2 = new Person("fengjie",18);
        System.out.println(p1.equals(p2));
        System.out.println("p1:hashcode "+p1.hashCode());
        System.out.println("p2:hashcode "+p2.hashCode());
        System.out.println(p1==p2);
        HashSet<Person> pset = new HashSet<>();
        pset.add(p1);
        pset.add(p2);
        for (Person p : pset){
            System.out.println(p);
        }
    }
}
