package com.learn.newcoder;
/**
 * @Author fengjie
 * @Description
 * @Time 19:26
 */
@SuppressWarnings("Duplicates")
public class SingleLinkedListReverse {
    static class Node{
        private Object value;
        private Node next;
        public Node() {
        }
        public Node(Object value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        reverse(node);
    }

    /**
     * 链表翻转
     * @param head 头结点
     */
    private static void reverse(Node head){
        if(head == null){
            return;
        }
        Node p = head;
        Node q = p.next;
        head.next = null;
        while(q != null){
            Node r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head = p;
        System.out.println(head);
    }

    /**
     * 检查链表中的环
     * @param head 头结点
     */
    private void checkRing(Node head){

    }
}
