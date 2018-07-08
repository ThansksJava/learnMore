package com.cnpc.sss.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/8
 * @Time 19:15
 */
public class InorderTraversal {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            Stack<TreeNode> s = new Stack<>();
            while(!s.empty() || root != null){
                if (root != null){
                    s.push(root);
                    root = root.left;
                }else {
                    root = s.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(node));

    }
}
