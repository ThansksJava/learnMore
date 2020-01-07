package com.learn.leetcode;

import java.util.Arrays;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2020/1/6
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length==0){
            return;
        }
        int i = -1;
        int j = nums.length;
        int index = 0;
        while(index < j){
            if(nums[index] < 1){
                swap(nums,++i,index++);
            }
            else if(nums[index]>1){
                swap(nums,--j,index);
            }
            else{
                index++;
            }
        }
    }

    public static void swap(int [] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int [] a = {2,0,2,1,1,0};
        sortColors(a);
        System.out.println(Arrays.asList(a));
    }
}
