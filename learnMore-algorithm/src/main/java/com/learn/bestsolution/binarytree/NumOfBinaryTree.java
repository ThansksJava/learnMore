package com.learn.bestsolution.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 根据中序1,2,3...N
 * 有多少种可能的BST
 * 中序有序一定是搜索二叉树
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/10/17
 */
public class NumOfBinaryTree {
    /**
     * 统计数目
     * @param n
     * @return
     */
    public static int getNum(int n){
        //一个节点是一棵树，n < 1 是一棵空树
        if(n < 2){
            return 1;
        }
        int [] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

    /**
     * 返回头结点的集合
     * @param n
     * @return
     */
    public static List<Node> generateTrees(int n){
        return generate(1,n);
    }

    public static List<Node> generate(int start, int end){
        List<Node> res = new LinkedList<>();
        if(start > end){
            res.add(null);
        }
        Node head = null;
        for (int i = start; i < end + 1; i++) {
            head = new Node(i);
            List<Node> lSubs = generate(start,i - 1);
            List<Node> rSubs = generate(i + 1,end);
            for (Node lSub : lSubs) {
                for (Node rSub : rSubs) {
                    head.left = lSub;
                    head.right = rSub;
                    res.add(cloneTree(head));
                }
            }
        }
        return res;
    }

    public static Node cloneTree(Node head){
        if(head == null){
            return null;
        }
        Node res = new Node(head.value);
        res.left = cloneTree(head.left);
        res.right = cloneTree(head.right);
        return res;
    }




}
