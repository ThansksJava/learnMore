package com.cnpc.sss.jianzhioffer;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/2/25 14:18
 */
public class Node{
    private Object value;
    private Node next;
    public Node() {
    }
    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}