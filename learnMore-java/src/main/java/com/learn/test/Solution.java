package com.learn.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static List<String> ret = new ArrayList<>();
    static boolean [] used = null;
    public static String[] permutation(String s) {
        if(s == null || s.length() == 0){
            return new String[0];
        }
        char [] arr = s.toCharArray();
        Arrays.sort(arr);
        used = new boolean[s.length()];
        backtracking(arr, "");
        String [] res = new String[ret.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = ret.get(i);
        }
        return res;
    }

    public static void backtracking(char[] s, String ele ){
        if(ele.length() == s.length){
            ret.add(ele);
            return;
        }
        // 每次都从头开始遍历，通过used判断是否这个字母已用
        for(int i = 0; i < s.length; i++){
            if(i > 0 && s[i] == s[i - 1] && used[i - 1] == false){
                continue;
            }
            if(used[i] == false){
                used[i] = true;
                ele = ele + s[i];
                backtracking(s, ele);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        permutation("abc");
    }
}