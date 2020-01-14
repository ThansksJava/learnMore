package com.learn.leetcode;

import java.util.*;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2020/1/13
 */
public class HIndex {
    public static int hIndex(int[] citations){
        Integer [] citationsI = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            citationsI[i] = citations[i];
        }
        Arrays.sort(citationsI, (o1, o2) -> o2-o1);
        for (int citation : citationsI) {
            System.out.print(citation+",");
        }
        for (int i = 0; i < citationsI.length; i++) {
            if (i >= citations[i]){
                return i - 1;
            }
        }
        return citationsI.length;
    }

    public static void main(String[] args) {
//        int [] citations = {3,0,6,1,5};
        int [] citations = {1,2};
        int h = hIndex(citations);
//        System.out.println(h);
    }
}
