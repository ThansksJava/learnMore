package com.cnpc.sss.newcoder;

import java.util.Arrays;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/22
 * @Time 17:41
 */
public class PutSmallerLeft {
    public static void putLeft(int [] array,int left,int right,int target){
        if(right - left + 1 > array.length){
            return;
        }
        int less = left - 1;
        for(int start = left; start < right - left + 1;start++){
            if(array[start] <= target){
                swap(array,++less,start);
            }
        }
        System.out.println(Arrays.toString(array));
    }
    public static void swap(int [] array,int i,int j){
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }
    public static void main(String[] args) {
        int [] array = {6,4,5,2,1};
        putLeft(array,0,4,5);
    }
}
