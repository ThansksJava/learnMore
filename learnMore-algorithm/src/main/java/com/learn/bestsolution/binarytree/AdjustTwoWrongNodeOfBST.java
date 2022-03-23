package com.learn.bestsolution.binarytree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/9
 */
public class AdjustTwoWrongNodeOfBST {
    public static Node[] getTwoErrNodes(Node head){
        Node[] errs = new Node[2];
        if(head == null){
            return errs;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        while(!stack.isEmpty() || head != null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                if(pre != null && pre.value > head.value){
                    errs[0] = errs[0] == null ? pre: errs[0];
                    errs[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errs;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.peek();

        ArrayDeque<List<Integer>> deque = new ArrayDeque<>();

    }
}
