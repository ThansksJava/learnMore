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


    public static Node<Integer> reversePartList(Node<Integer> head,int start,int end){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> sPre = null;
        Node<Integer> eBeh = null;
        Node<Integer> cur = head;
        int index = 1;
        while (cur != null && index <= end+1){
            if(start != 0 &&index == start-1){
                sPre = cur;
            }
            if(index == end+1){
                eBeh = cur;
            }
            cur = cur.next;
            index++;
        }
        Node<Integer> hp = null;
        Node<Integer> hq = null;
        Node<Integer> hr = null;
        if(sPre != null){
           hp = sPre.next;
           hq = sPre.next.next;
           hr = sPre.next.next.next;
        }else {
            hp = head;
            hq = head.next;
            hr = head.next.next;
        }

        while(hq != eBeh){
            hq.next = hp;
            hp = hq;
            hq = hr;
            if(hr != null){
                hr = hr.next;
            }
        }
        if(sPre != null){
            Node<Integer> tmp = sPre.next;
            tmp.next = eBeh;
            sPre.next = hp;
            return head;
        }else {
            head.next=eBeh;
            return hp;
        }
    }

    /**
     * TODO 以后再想，我丢
     * 从尾部开始按组反转链表
     * @param head 头结点
     * @param k 一组节点个数
     * @return
     */
    public static Node<Integer> reverseListByGroup(Node<Integer> head,int k){
        if(head == null || head.next == null){
            return head;
        }
        Node cur = head;
        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        cur = head;
        int tmp = 1;
        Node<Integer> afterNode = null;
        while(len - k + 1 > 0){
            if(tmp == len - k || len - k == 0){
                Node<Integer> node1 = cur.next;
                Node<Integer> node2 = node1.next;
                node1.next = afterNode;
                int count = 1;
                while(count < k){
                    Node node3 = node2.next;
                    node2.next = node1;
                    node1 = node2;
                    node2 = node3;
                    count++;
                }
                cur.next = node1;
                afterNode = node1;
                len = tmp;
                tmp = 1;
                cur = head;
                continue;
            }
            cur =cur.next;
            tmp++;
        }
        return head;
    }
    public static void main(String[] args) {
//        CommonNode.printSingleList(reverseSingleList(CommonNode.singleHead));
//        CommonNode.printSingleList(reversePartList(CommonNode.singleHead,1,8));
        Node<Integer> node = new Node(1);
        Node<Integer> node1 = new Node(2);
        Node<Integer> node2 = new Node(3);
        Node<Integer> node3 = new Node(4);
        Node<Integer> node4 = new Node(5);
        Node<Integer> node5 = new Node(6);
        Node<Integer> node6 = new Node(7);
        Node<Integer> node7 = new Node(8);
        node6.next = node7;
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;
        Node<Integer> singleHead = node;
        CommonNode.printSingleList(reverseListByGroup(node,4));
    }


    public Node reversePartNode (Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next;
        while(node1 != tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(fPre != null){
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
