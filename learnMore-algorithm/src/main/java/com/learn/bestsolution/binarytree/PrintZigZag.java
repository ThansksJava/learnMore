package com.learn.bestsolution.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ZigZag打印，使用双端队列，根据打印顺序从头或者尾出队列
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/5
 */
public class PrintZigZag {
    public static void printByZigZag(Node head){
        if(head == null){
            return;
        }
        Deque<Node> dq = new LinkedList<>();
        int level = 1;
        boolean lr = true;
        Node last = head;
        Node nLast = null;
        dq.offerFirst(head);
        printLevelAndOrientation(level++,lr);
        while (!dq.isEmpty()){
            //lr是true说明本层从左向右打印，那么下一层将从右向左打印
            if (lr) {
                head = dq.pollFirst();
                //所以下一层的最后一个节点就是当前队列头元素的左孩子，从尾部放入
                if(head.left != null){
                    nLast = nLast == null?head.left:nLast;
                    dq.offerLast(head.left);
                }
                if(head.right != null){
                    nLast = nLast == null ? head.right : nLast;
                    dq.offerLast(head.right);
                }
            }else{
                head = dq.pollLast();
                if(head.right != null){
                    nLast = nLast == null?head.left:nLast;
                    dq.offerFirst(head.right);
                }
                if(head.left != null){
                    nLast = nLast == null ? head.left : nLast;
                    dq.offerFirst(head.left);
                }
            }
            System.out.print(head.value + " ");
            if(head == last && !dq.isEmpty()){
                lr = !lr;
                last = nLast;
                nLast = null;
                System.out.println();
                printLevelAndOrientation(level++,lr);
            }
        }
    }
    public static void printLevelAndOrientation(int level,boolean lr){
        System.out.print("Level "+ level + "from ");
        System.out.print(lr ? "left to right: " : "right to left: " );
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
        printByZigZag(n1);
    }
}
