package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

/**
 * 将链表调整为以某值为借左大中等右小的结构
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/7
 */
public class ListPartition {
    public static Node<Integer>  listPartition1(Node<Integer> head,int val){
        if(head == null || head.next == null){
            return head;
        }
        // 求链表长度
        int len = 0;
        Node<Integer> node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        int cap = 0;
        Node<Integer>[] arr = new Node[len];
        while(head != null){
            if(cap == 0){
                arr[cap++] = head;
            }else {
                if(head.value >= val){
                    // 同当前位置的前面位置比较
                    int i = cap - 1;
                    for(;arr[i].value > val;i--){
                        arr[i+1] = arr[i];
                    }
                    arr[i+1] = head;
                }else {
                    arr[cap] = head;
                }
                cap++;
            }
            head = head.next;
        }
        for(int i = 0;i < len;i++){
            if(i == 0){
                head = arr[i];continue;
            }
            arr[i-1].next = arr[i];
        }
        return head;
    }

    public static void main(String[] args) {
    }
}
