package com.learn.bestsolution.binarytree;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/27
 */
public class NextNode {
    public static Node getNextNode(Node node){
        if(node == null){
            return node;
        }
        if(node.right != null){
            return getLeftMost(node.right);
        }else {
            Node parent = node.right;
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if(node == null){
            return node;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
