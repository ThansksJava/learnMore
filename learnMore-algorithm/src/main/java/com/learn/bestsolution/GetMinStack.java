package com.learn.bestsolution;

import java.util.Stack;

/**
 * @author fengjie
 * @version 1.0
 * @date 2019/6/22
 */
public class GetMinStack {
    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();
    public void push(Integer i){
        stackData.push(i);
        if(stackMin.isEmpty()) {
            stackMin.push(i);
        }else {
            Integer top = stackMin.peek();
            if(i <= top){
                stackMin.push(i);
            }
        }
    }

    public Integer pop() throws Exception{
        if(stackData.isEmpty()){
            throw new Exception("栈空");
        }
        Integer v = stackData.pop();
        Integer topMin = stackMin.peek();
        if(v.equals(topMin)){
            stackMin.pop();
        }
        return v;
    }
    public Integer getMin() throws Exception{
        if (stackData.isEmpty()){
            throw new Exception("栈空");
        }
        return stackMin.peek();
    }
}
