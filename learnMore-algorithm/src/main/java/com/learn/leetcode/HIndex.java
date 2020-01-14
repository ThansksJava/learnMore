package com.learn.leetcode;

import java.util.*;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2020/1/13
 */
public class HIndex {
    public static int hIndex(int[] citations){
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = len-1; i >= 0; i--) {
            if (citations[i] <= len-i-1){
                return len-i-1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
//        int [] citations = {3,0,6,1,5};
        int [] citations = {1,2};
        int h = hIndex(citations);
//        System.out.println(h);
    }
}
