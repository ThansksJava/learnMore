package com.learn.practice;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/11 20:07
 */
public class BinarySearchTree {
    static class Node{
        int value;
        Node left;
        Node right;
    }
    public static void delete(Node head,int value){
        Node p = head;
        Node pf = null;
        while(p != null && p.value != value){
            pf = p;
            if(value > p.value){
                p=p.right;
            }else {
                p = p.left;
            }
        }

        if(p == null){
            return;
        }

        if(p.left !=null && p.right != null){
            Node minP = p.right;
            Node minPP = p;
            while(minP.left != null){
                minPP = minP;
                minP = minP.left;
            }
            p.value = minP.value;
            p = minP;
            pf = minPP;
        }
    }
}
