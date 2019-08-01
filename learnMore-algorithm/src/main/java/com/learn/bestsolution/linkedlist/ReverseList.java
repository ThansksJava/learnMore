package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 反转链表
 * @author fengjie
 * @version 1.0
 * @date Created in 2019年7月30日14:20:25
 */
public class ReverseList {
    public static Node<Integer> reverseSingleList(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> p = head;
        Node<Integer> q = head.next;
        Node<Integer> r = head.next.next;
        while(q != null){
            q.next = p;
            p = q;
            q=r;
            if(r != null){
                r = r.next;
            }
        }
        head.next = null;
        return p;
    }
    public static Node<Integer> reverseDoubleList(Node<Integer> head){
        Node<Integer> pre = null;
        Node<Integer> next = null;
        while(head != null){
            next = head.next;
            head.pre = pre;
            head.next = next;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        CommonNode.printSingleList(reverseSingleList(CommonNode.singleHead));
    }
}
