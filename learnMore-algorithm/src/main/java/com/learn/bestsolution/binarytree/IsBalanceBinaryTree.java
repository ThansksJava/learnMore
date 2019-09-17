package com.learn.bestsolution.binarytree;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/17
 */
public class IsBalanceBinaryTree {
    public static boolean isBalanceTree(Node root){
        if(root == null){
            return true;
        }
        if(Math.abs(height(root.left,1) - height(root.right,1)) > 1){
            return false;
        }
        return isBalanceTree(root.left) && isBalanceTree(root.right);
    }
    public static int height(Node node,int n){
        if(node == null){
            return n;
        }
        return Math.max(height(node.left,n+1),height(node.right,n+1));
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

        System.out.println(isBalanceTree(n1));
    }
}
