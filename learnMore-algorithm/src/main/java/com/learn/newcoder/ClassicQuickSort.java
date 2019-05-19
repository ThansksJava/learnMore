package com.learn.newcoder;

import java.util.Arrays;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/25
 * @Time 10:10
 */

/**
 * 复杂度：如果每次把最后一个数作为切分的点  有序跟无序都需要每次进行一个数的切分，N*(n-1)*...*1 n^2
 */
public class ClassicQuickSort {
    public static void quickSort(int [] array,int start,int end){
        if(start < end){
            int part = partition(array,start,end);
            quickSort(array,start,part-1);
            quickSort(array,part+1,end);
        }
        System.out.println(Arrays.toString(array));

    }
    /**
     * 切分
     * */
    public static int partition(int [] array,int left,int right){
        int smaller = left - 1;
        int index = left;
        while(index < right){
            /*选择最后一个数作为切点*/
            if(array[index] <= array[right]){
                SortUtils.swap(array,++smaller,index++);
            }
            else {
                index++;
            }
        }
        SortUtils.swap(array,++smaller,right);
        return smaller;
    }
    public static void main(String[] args) {
        int [] array = {6,9,4,5,7,8,2};
        quickSort(array,0,array.length-1);
    }
}
