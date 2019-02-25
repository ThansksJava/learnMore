package com.cnpc.sss.jianzhioffer;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/2/25 13:49
 */
@SuppressWarnings("Duplicates")
public class ReverseList {
    static class Node{
        private Object value;
        private Node next;
        public Node() {
        }
        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
    private static void reverseList(Node head){
        if(head == null  || head.next==null){
            System.out.println(head);
            return;
        }
        Node reverse = null;
        Node pNode =  head;
        Node pPre = null;
        while(pNode != null){
            Node pNext = pNode.next;
            if(pNext == null){
                reverse = pNode;
            }
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        System.out.println(reverse);
    }
    private static void reverseList1(Node head){
        if(head == null  || head.next==null){
            System.out.println(head);
            return;
        }
        Node p = head;
        Node q = p.next;
        head.next=null;
        while(q != null){
            Node r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        reverseList(node1);
        reverseList1(node1);
    }
}
