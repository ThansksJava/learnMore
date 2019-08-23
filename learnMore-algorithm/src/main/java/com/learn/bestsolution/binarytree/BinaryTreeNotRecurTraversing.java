package com.learn.bestsolution.binarytree;

import java.util.Stack;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/23
 */
public class BinaryTreeNotRecurTraversing {
    /**
     * 先序遍历二叉树
     * @param root
     */
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.empty()){
            Node n = s.pop();
            System.out.println(n.value);
            //左孩子先打印所以后入栈
            if(n.right != null){
                s.push(n.right);
            }
            if(n.left != null){
                s.push(n.left);
            }
        }
    }

    /**
     * 中序遍历二叉树
     * @param root
     */
    public static void inOrder(Node root){
        Stack<Node> s = new Stack<>();
        while(root != null || !s.empty()){
            if(root != null){
                s.push(root);
                root = root.left;
            }else {
                Node r = s.pop();
                System.out.println(r.value);
                root = r.right;
            }
        }
    }
    /**
     * 后序遍历二叉树
     * @param root
     */
    public static void posOrder(Node root){
        if(root == null){
            return;
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


        inOrder(n1);
    }
}
