package com.cnpc.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/8/23
 * @Time 9:33
 */
public class TreeNode {
    TreeNode parent   = null;
    List children = new ArrayList();

    public synchronized void addChild(TreeNode child){
        if(!this.children.contains(child)) {
            this.children.add(child);
            child.setParentOnly(this);
        }
    }

    public synchronized void addChildOnly(TreeNode child){
        if(!this.children.contains(child)){
            this.children.add(child);
        }
    }

    public synchronized void setParent(TreeNode parent){
        this.parent = parent;
        parent.addChildOnly(this);
    }

    public synchronized void setParentOnly(TreeNode parent){
        this.parent = parent;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
    }
}
