package com.learn.leetcode;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/16
 * @Time 19:45
 */
class Solution {
    public int reverse(int x) {
        int a = Math.abs(x);
        boolean flag = x == a?true:false;
        int result = 1;
        int jw = 1;
        while(a / 10 != 0){
            result += (a % 10) * jw++ * 10;
        }
        if (!flag){
            result = result;
        }
        return 0;
    }

    public static void main(String[] args) {
        int x = -10;
        String s = String.valueOf(x);
        System.out.println(s);
    }
}