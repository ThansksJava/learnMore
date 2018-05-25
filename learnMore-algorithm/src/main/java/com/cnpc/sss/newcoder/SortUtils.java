package com.cnpc.sss.newcoder;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/25
 * @Time 9:28
 */
public class SortUtils {
    public static void swap(int [] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
