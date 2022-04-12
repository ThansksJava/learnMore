package com.learn.test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> list = new ArrayList<>();
    public static int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        int sum = 0;
        for(int a : list){
            sum += a;
        }
        return sum;
    }

    public static void sumNumbers(TreeNode root,int sum) {
        if(root == null){
            list.add(sum);
            return;
        }
        sum = sum * 10 + root.val;
        sumNumbers(root.left, sum);
        sumNumbers(root.right, sum);
    }

    public static void main(String[] args) {

    }
}