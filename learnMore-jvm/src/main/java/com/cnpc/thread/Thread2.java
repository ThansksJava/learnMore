package com.cnpc.thread;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/8/23
 * @Time 9:35
 */
public class Thread2 implements Runnable {
    private TreeNode treeNode = null;
    private TreeNode treeNode2 = null;
    public Thread2(TreeNode treeNode, TreeNode treeNode2){
        this.treeNode = treeNode;
        this.treeNode2 = treeNode2;
    }
    @Override
    public void run() {
        treeNode.setParent(treeNode2);
    }
}
