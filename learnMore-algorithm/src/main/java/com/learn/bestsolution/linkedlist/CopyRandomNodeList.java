package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含有随机指针节点的链表
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/12
 */
public class CopyRandomNodeList {
    /**
     * 使用map保存节点和节点的副本,分别为k，v
     * @param head
     * @return
     */
    public static Node<Integer> copyListWithRandomNode(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Map<Node<Integer>,Node<Integer>> m = new HashMap<>();
        Node<Integer> cur = head;
        while(cur != null){
            m.put(cur,new Node<Integer>(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            m.get(cur).next = cur.next;
            m.get(cur).rand = cur.rand;
        }
        return m.get(head);
    }
}
