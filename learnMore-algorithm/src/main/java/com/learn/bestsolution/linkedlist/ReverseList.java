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
    public static void main(String[] args) {
//        CommonNode.printSingleList(reverseSingleList(CommonNode.singleHead));
        CommonNode.printSingleList(reversePartList(CommonNode.singleHead,1,8));
    }
}
