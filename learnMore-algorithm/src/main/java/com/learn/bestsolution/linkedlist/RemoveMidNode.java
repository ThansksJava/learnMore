package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019年7月29日16:00:03
 */
public class RemoveMidNode {
    public static Node<Integer> removeMidNode(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head;
        }
        Node pre = head;
        Node cur = head.next.next;
        while(cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node(9);
        Node<Integer> node1 = new Node(7);
//        Node<Integer> node2 = new Node(6);
//        Node<Integer> node3 = new Node(10);
//        Node<Integer> node4 = new Node(12);
//        Node<Integer> node5 = new Node(15);
//        Node<Integer> node6 = new Node(13);
//        node5.next = node6;
//        node4.next = node5;
//        node3.next = node4;
//        node2.next = node3;
//        node1.next = node2;
        node.next = node1;
        Node res = removeMidNode(node);
        while(res != null){
            System.out.print(res.value+"->");
            res = res.next;
        }
        System.out.println("null");
    }
}
