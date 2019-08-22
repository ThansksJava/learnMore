package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/22
 */
public class MergeLRPart {
    /**
     * 使用快慢指針尋找中點
     * 合并
     * @param head
     */
    public static void mergeLRPart(Node<Integer> head){
        if (head == null || head.next == null){
            return;
        }
        Node<Integer> mid = head;
        Node<Integer> right = head.next;
        while(right.next != null && right.next.next != null){
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head,right);
        System.out.println();
    }
    public static void mergeLR(Node<Integer> left,Node<Integer> right){
        Node next = null;
        while(left.next != null){
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;

        }
        left.next = right;
        System.out.println();
    }
    public static void main(String[] args) {
        mergeLRPart(CommonNode.singleHead);
    }
}
