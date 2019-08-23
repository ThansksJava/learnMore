package com.learn.bestsolution.binarytree;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/23
 */
public class BinaryTreeRecurTraversing {
    /**
     * 先序遍历二叉树
     * @param root
     */
    public static void preOrder(Node root){
        if(root == null){
            System.out.println("null");
        }
        System.out.println(root.value);
        if(root.left != null){
            preOrder(root.left);
        }
        if(root.right != null){
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历二叉树
     * @param root
     */
    public static void inOrder(Node root){
        if(root == null){
            System.out.println("null");
        }

        if(root.left != null){
            inOrder(root.left);
        }
        System.out.println(root.value);

        if(root.right != null){
            inOrder(root.right);
        }
    }
    /**
     * 后序遍历二叉树
     * @param root
     */
    public static void posOrder(Node root){
        if(root == null){
            System.out.println("null");
        }
        if(root.left != null){
            posOrder(root.left);
        }

        if(root.right != null){
            posOrder(root.right);
        }
        System.out.println(root.value);
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


        posOrder(n1);
    }
}
