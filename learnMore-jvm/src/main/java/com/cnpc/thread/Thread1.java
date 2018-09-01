package com.cnpc.thread;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/8/23
 * @Time 9:35
 */
public class Thread1 implements Runnable {
    private TreeNode treeNode = null;
    private TreeNode treeNode2 = null;
    public Thread1(TreeNode treeNode,TreeNode treeNode2){
        this.treeNode = treeNode;
        this.treeNode2 = treeNode2;
    }
    @Override
    public void run() {
        treeNode.addChild(treeNode2);
    }
}
