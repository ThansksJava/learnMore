package com.learn.bestsolution.binarytree;

/**
 * 将有序数组按照中序重构为一个搜索平衡二叉树
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/25
 */
public class SortArrayTOBinaryBalanceTree {
    public static Node buildTree(int [] array){
        if (array == null || array.length == 0){
            return null;
        }
        return build(array,0,array.length - 1);
    }


    public static Node build(int [] sortArr,int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        Node head = new Node(sortArr[mid]);
        head.left = build(sortArr,start,mid-1);
        head.right = build(sortArr,mid+1,end);
        return head;
    }
}
