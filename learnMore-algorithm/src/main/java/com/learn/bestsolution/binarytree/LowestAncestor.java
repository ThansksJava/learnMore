package com.learn.bestsolution.binarytree;

/**
 * 两个节点最近的公共祖先
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/10/9
 */
public class LowestAncestor {
    public static Node lowerstAncestor(Node head, Node n1, Node n2){
        if(head == null || head == n1 || head == n2){
            return head;
        }
        Node left = lowerstAncestor(head.left,n1,n2);
        Node right = lowerstAncestor(head.right,n1,n2);
        if(left != null && right != null){
            return head;
        }
        return left != null?left : right;

    }
}
