package com.cnpc.thread;

import sun.reflect.generics.tree.Tree;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/8/23
 * @Time 9:42
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode treeNode2 = new TreeNode();

        new Thread(new Thread1(treeNode,treeNode2)).start();
        new Thread(new Thread2(treeNode,treeNode2)).start();
    }
}
