package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/5
 */
public class Palindrome {
    /**
     * 1、求出中点，偶数个node中间两个node
     * 2、右半部分反转
     * 3、对比
     * 4、恢复链表
     * @param head
     * @return
     */
    public static boolean isPalindrome(Node<Integer> head){
        if(head == null || head.next == null){
            return true;
        }
        boolean flag = true;
        Node<Integer> node1 = head.next;
        Node<Integer> node2 = head;
        //循环后node1是中间节点
        while(node2.next != null && node2.next.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
        }
        //重新复制node2作为右半边第一个节点
        node2 = node1.next;
        node1.next = null;
        //反转右半边
        Node<Integer> node3 = null;
        while(node2 != null){
            node3 = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = node3;
        }
        // node1 作为right node head 接下来参与对比，使用node3保存
        node3 = node1;
        node2 = head;
        while (node1 != null && node2 != null){
            if(!node1.value.equals(node2.value)){
                flag = false;
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        //node3此时是反转后的右半部分的头结点
        node1 = node3.next;
        //开始逆转反转
        node3.next = null;
        while(node1 != null){
            node2 = node1.next;
            node1.next = node3;
            node3 = node1;
            node1 = node2;
        }
        return flag;
    }

    public static void main(String[] args) {
        boolean flag = isPalindrome(CommonNode.palindromeHead);
        System.out.println(flag);
    }
}
