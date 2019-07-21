package com.learn.test;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/29 19:57
 */
public class Outer {
    private String outName="outer";
    private static int a = 0;
    private class Inner{
        private String innerName = outName+":inner";
    }

    public static void main(String[] args) {
        Outer out = new Outer();
        Outer.Inner inner = out.new Inner();
//        Outer.Inner inner1 = out
        System.out.println(inner.innerName);
        /**
         * 不能有访问修饰符和static修饰符
         */
        class A{
            private String localInnerClass = "localInnerClass";
            A(){
                this.localInnerClass = "1111";
            }
        }
    }
}
