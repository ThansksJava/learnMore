package com.learn.common;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/2/25 14:18
 */
public class Node{
    public Object value;
    public Node next;
    public Node left;
    public Node right;
    public Node() {
    }
    public Node(Object value) {
        this.value = value;
    }
}