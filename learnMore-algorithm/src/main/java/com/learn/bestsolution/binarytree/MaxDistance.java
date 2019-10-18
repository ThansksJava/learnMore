package com.learn.bestsolution.binarytree;

/**
 * 求二叉树两节点的最远距离，经过的节点个数，包含本身
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/10/11
 */
public class MaxDistance {
    public int maxDistance(Node head){
        int [] record = new int[1];
        return posOrder(head,record);
    }
    public int posOrder(Node head,int [] record){
        if(head == null){
            record[0] = 0;
            return 0;
        }
        int lmax = posOrder(head.left,record);
        int maxFromLeft = record[0];
        int rmax = posOrder(head.right,record);
        int maxFromRight = record[0];
        int curNodeMax = maxFromLeft + maxFromRight + 1;
        record[0] = Math.max(maxFromLeft,maxFromRight) + 1;
        return Math.max(Math.max(lmax,rmax),curNodeMax);
    }
}
