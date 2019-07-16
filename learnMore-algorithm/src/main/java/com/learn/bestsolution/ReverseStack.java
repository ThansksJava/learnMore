package com.learn.bestsolution;

import java.util.Stack;

/**
 * 使用递归和栈函数逆序一个栈
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/6/25 10:08
 */
public class ReverseStack {
    public static Integer getAndRemoveLastElement(Stack<Integer> stack){
        int e = stack.pop();
        if(stack.isEmpty()){
            return e;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(e);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i <= 5;i++){
            stack.push(i);
        }
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
