package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/2
 */
public class JosephusKill {

    public static Node<Integer>  josephusKillNomal(Node<Integer> head,int m){
        if(head == null || head.next == null || m < 1){
            return head;
        }
        Node<Integer> node = head;
        int idx = 1;
        while(node.next != node){
            if (idx++ == m-1){
                Node<Integer> tmp = node.next;
                node.next = tmp.next;
                tmp.next = null;
                idx = 1;
            }
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        CommonNode.printSingleList(josephusKillNomal(CommonNode.circleHead,3));
    }

}
