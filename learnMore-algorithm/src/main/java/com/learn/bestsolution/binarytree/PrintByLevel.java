package com.learn.bestsolution.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/4
 */
public class PrintByLevel {
    public static void print(Node head){
        if(head == null){
            return;
        }
        Node last = head;
        Node nLast = null;
        int l = 1;
        Queue<Node> q = new LinkedList();
        q.offer(head);
        System.out.print("Level"+ l++ + ":");
        while(!q.isEmpty()){
            Node c = q.poll();
            System.out.print(c.value+" ");
            if(c.left != null){
                nLast = c.left;
                q.offer(c.left);
            }
            if(c.right != null){
                nLast = c.right;
                q.offer(c.right);
            }
            if(c == last && !q.isEmpty()){
                System.out.println();
                System.out.print("Level"+ l++ + ":");
                last = nLast;
            }
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        print(n1);
    }
}
