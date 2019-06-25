package com.learn.bestsolution;

import java.util.Stack;

/**
 * 使用两个栈设计一个队列
 * push栈和pop栈
 * 必须一次全部push到pop栈，pop栈不为空绝对不能进行push
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/6/24 16:39
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();

    public void add(Integer e){
        stackPush.push(e);
    }
    public Integer poll() throws Exception {
        if(stackPop.isEmpty()){
            if(!stackPush.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }else {
                throw new Exception("栈为空无法出栈");
            }
        }
        return stackPop.pop();
    }
    public Integer peek() throws Exception {
        if(stackPop.isEmpty()){
            if(!stackPush.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }else {
                throw new Exception("栈为空无法出栈");
            }
        }
        return stackPop.peek();
    }
}
