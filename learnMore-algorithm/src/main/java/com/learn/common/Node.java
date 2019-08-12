package com.learn.common;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/2/25 14:18
 */
public class Node<T>{
    public T value;
    public Node<T> next;
    public Node<T> left;
    public Node<T> right;
    public Node<T> pre;
    public Node<T> rand;
    public Node() {
    }
    public Node(T value) {
        this.value = value;
    }
}