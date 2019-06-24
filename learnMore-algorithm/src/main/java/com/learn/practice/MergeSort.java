package com.learn.practice;

import java.util.Arrays;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/6/19 11:17
 */
public class MergeSort {
    public static void mergeSort(int [] arr,int low,int high){
        if(high <= low){
            return;
        }
        int mid = (low+high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge(arr,low,mid,high);

    }
    public static void merge(int [] arr,int low,int mid,int high){
        int left = low;
        int right = mid + 1;
        int [] tmpArr = new int [high+1];
        for(int i = low;i <= high;i++){
            tmpArr[i] = arr[i];
        }
        for(int i = low;i <= high;i++){
            if(left > mid){
                arr[i] = tmpArr[right++];
            }else if (right > high){
                arr[i] = tmpArr[left++];
            }else if(tmpArr[right] < tmpArr[left]){
                arr[i] = tmpArr[right++];
            }else {
                arr[i] = tmpArr[left++];
            }
        }
    }
    public static void main(String[] args) {
        int[] testArr = {3,7,42,8,0,5, 66, 3, 80, 11, 2};
        System.out.println(Arrays.toString(testArr));

        mergeSort(testArr,0, testArr.length - 1);

        System.out.println(Arrays.toString(testArr));
    }
}
