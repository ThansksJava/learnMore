package com.learn.bestsolution.binarytree;

/**
 * 给定一棵完全二叉树的头结点head，返回其节点个数
 * 时间复杂度低于O(N)
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/10/22
 */
public class NodesNumOfCBT {

    public static int nodeNum(Node head){
        if (head == null){
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head,1));
    }

    public static int bs(Node node, int l, int h){
        //说明已经到底了，node是底层的叶节点
        if(l == h){
            return l;
        }
        // 右子树能否到达最后一层，到了说明node的左子树是满二叉树
        if(mostLeftLevel(node.right, l + 1) == h){
            return (1 << (h - 1)) + bs(node.right,l + 1, h);
        }else{
            // 不能则说明node的右子树应该是一棵满二叉树
            // 需要再求出其左子树的节点个数，递归求
            return (1 << (h - l - 1)) + bs(node.left,l + 1,h);
        }
    }

    /**
     * 当前节点的层数
     * @param node
     * @param level
     * @return
     */
    public static int mostLeftLevel(Node node, int level){
        while (node != null){
            level++;
            node = node.left;
        }
        return level - 1;
    }
}
