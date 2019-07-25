package com.learn.bestsolution.stackandqueue;

import java.util.Stack;

/**
 * 借助一个栈实现另一个栈的排序
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/6/26 11:14
 */
public class SortStackByAnother {
    public static void sort(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()){
            int i = stack.pop();
            //大于help栈顶元素时，讲help中的元素先放入stack
            while(!help.isEmpty() && help.peek() > i){
                stack.push(help.pop());
            }
            //再把大的放进去
            help.push(i);
        }
        //help已经是从小到大的了,放入stack
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
