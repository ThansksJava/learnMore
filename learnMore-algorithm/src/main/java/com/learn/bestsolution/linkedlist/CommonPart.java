package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019年7月25日14:15:30
 */
public class CommonPart {
    public static void getCommonPart(Node<Integer> node1,Node<Integer> node2){
        while(node1.next != null && node2.next != null){
            if (node1.next.value < node2.next.value){
                node1 = node1.next;
            }else if(node2.next.value < node1.next.value){
                node2 = node2.next;
            }else {
                System.out.println(node1.next.value);
            }
            System.out.println();
        }
    }
}
