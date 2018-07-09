package com.cnpc.sss.leetcode;

import java.util.Arrays;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/9
 * @Time 9:33
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if(digits!=null){
            int len = digits.length;
            int [] newDigits = new int[len+1];
            int jw = 0;
            while(--len >= 0){
                int val = digits[len]+1;
                jw = val / 10;
                if(jw == 0){
                    digits[len] = val;jw = 0;break;
                }else{
                    digits[len] = val % 10;
                    continue;
                }
            }
            if (jw != 0){
                newDigits[0] = jw;
                for (int i = 0;i < len;i++){
                    newDigits[i+1] = digits[i];
                }
                return newDigits;
            }else {
                return digits;
            }
        }
        return  null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int []{9})));
    }
}
