package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019年7月30日14:37:29
 */
public class CommonNode {
    public static Node<Integer> singleHead = new Node<>();
    public static Node<Integer> circleHead = new Node<>();
    public static Node<Integer> doubleHead = new Node<>();
    public static Node<Integer> palindromeHead = new Node<>();
    static {
        Node<Integer> node = new Node(9);
        Node<Integer> node1 = new Node(7);
        Node<Integer> node2 = new Node(6);
        Node<Integer> node3 = new Node(10);
        Node<Integer> node4 = new Node(12);
        Node<Integer> node5 = new Node(15);
        Node<Integer> node6 = new Node(13);
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;
        singleHead = node;
    }
    static {
        Node<Integer> node = new Node(9);
        Node<Integer> node1 = new Node(7);
        Node<Integer> node2 = new Node(6);
        Node<Integer> node3 = new Node(10);
        Node<Integer> node4 = new Node(12);
        Node<Integer> node5 = new Node(15);
        Node<Integer> node6 = new Node(13);
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;
        node6.next = node;
        circleHead = node;
    }
    static {
        Node<Integer> node = new Node(9);
        Node<Integer> node1 = new Node(7);
        Node<Integer> node2 = new Node(6);
        Node<Integer> node3 = new Node(10);
        Node<Integer> node4 = new Node(12);
        Node<Integer> node5 = new Node(15);
        Node<Integer> node6 = new Node(13);
        node6.pre = node5;
        node6.next = null;
        node5.next = node6;
        node5.pre = node4;
        node4.next = node5;
        node4.pre = node3;
        node3.next = node4;
        node3.pre = node2;
        node2.next = node3;
        node2.pre = node1;
        
        node.next = node1;
        node.pre = null;
        doubleHead = node;
        
    }
    static {
        Node<Integer> node = new Node(1);
        Node<Integer> node1 = new Node(2);
        Node<Integer> node2 = new Node(3);
        Node<Integer> node3 = new Node(4);
        Node<Integer> node4 = new Node(5);
        Node<Integer> node5 = new Node(6);
        Node<Integer> node6 = new Node(4);
        Node<Integer> node7 = new Node(3);
        Node<Integer> node8 = new Node(2);
        Node<Integer> node9 = new Node(1);
        node8.next = node9;
        node7.next = node8;
        node6.next = node7;
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;
        palindromeHead = node;
    }
    public static void printSingleList(Node head){
        while(head != null){
            System.out.print(head.value+"->");
            head = head.next;
            if(head.next == head){
                break;
            }
        }
        System.out.println("null");
    }

    public static void printDoubleList(Node head){
        while(head != null){
            System.out.print(head.value+"->");
            head = head.next;
        }
        System.out.println("null");
    }
}
