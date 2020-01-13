package com.learn.leetcode;

import java.util.Arrays;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2020/1/13
 */
public class LargestNumber {
    public static String largestNumber(int [] num){
        int len = num.length;
        String [] s = new String[len];
        for (int i = 0; i < len; i++) {
            s[i] = num[i]+"";
        }
        Arrays.sort(s,(a,b)->(b+a).compareTo((a+b)));
        String ret="";
        //经过排序后，如果第一个值是0，那么后面的元素肯定是0
        boolean a0 = true;
        for (String s1 : s) {
            if(!"0".equals(s1)){
                a0=false;
            }
            ret+=s1;
        }
        return a0?"0":ret;
    }

    public static void main(String[] args) {
//        int [] a = {3,30,34,5,9};
        int [] a = {0,0,0,0,0};
        largestNumber(a);
    }
}
