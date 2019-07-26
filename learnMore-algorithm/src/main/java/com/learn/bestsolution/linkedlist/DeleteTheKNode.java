package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

/**
 * 删除第K个节点
 * @author fengjie
 * @version 1.0
 * @date Created in 2019年7月26日14:45:46
 */
public class DeleteTheKNode {
    /**
     * 删除<i>单链表</i>第K个位置的节点
     * 待删除节点的前一个节点
     * @param head
     * @param k
     */
    public static Node<Integer> deleteForSingleList(Node<Integer> head,int k){
        if(head == null){
            System.out.println("fuck,are you kidding me?");
            return head;
        }
        Node<Integer> node = head;
        while(node != null){
            k--;
            node = node.next;
        }
        if(k == 0){
            //待删除节点是头节点
            head = head.next;
        }else if(k > 0){
            System.out.println("stupid provider.this list isn`t so long");
        }else{
            node = head;
            //加到0停止遍历
            while(++k != 0){
                node = node.next;
            }
            node.next = node.next.next;
        }
        return head;
    }

    /**
     * 双向链表删除第K个节点
     * @param dHead
     * @param k
     * @return
     */
    public static Node<Integer> deleteForDoubleList(Node<Integer> dHead,int k){
        if(dHead == null){
            System.out.println("fuck,are you kidding me?");
            return dHead;
        }
        Node<Integer> node = dHead;
        while(node != null){
            k--;
            node = node.next;
        }
        if(k == 0){
            //待删除节点是头节点
            dHead = dHead.next;
            dHead.pre = null;
        }else if(k > 0){
            System.out.println("stupid provider.this list isn`t so long");
        }else{
            node = dHead;
            //加到0停止遍历
            while(++k != 0){
                node = node.next;
            }
            //多考虑一步当待删除元素是最后一个元素的时候
            Node<Integer> tmp  = node.next.next;
            node.next = tmp;
            if(tmp != null){
                tmp.pre = node;
            }
        }
        return dHead;
    }



    public static void main(String[] args) {
       Node<Integer> node = new Node(9);
       Node<Integer> node1 = new Node(7);
       Node<Integer> node2 = new Node(6);
       Node<Integer> node3 = new Node(10);
       Node<Integer> node4 = new Node(12);
       Node<Integer> node5 = new Node(15);
       Node<Integer> node6 = new Node(13);
       node5.next = node6;
       node4.next = node5;
       node3.next = node4;
       node2.next = node3;
       node1.next = node2;
       node.next = node1;
       Node<Integer> res = deleteForSingleList(node,4);
       while(res != null){
           System.out.print(res.value+"->");
           res = res.next;
       }
       System.out.println("null");
    }


}
