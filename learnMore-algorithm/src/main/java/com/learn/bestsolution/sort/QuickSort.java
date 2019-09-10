package com.learn.bestsolution.sort;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/10
 */
public class QuickSort {
    public static void quickSort(int [] arr,int start,int end){
        if(start >= end || arr == null || arr.length == 0){
            return;
        }
        int pivotIndex = partition(arr,start,end);
        quickSort(arr,start,pivotIndex-1);
        quickSort(arr,pivotIndex+1,end);
    }

    public static int partition(int [] arr, int start, int end){
        int rand = (int)Math.random()*(end - start + 1);
        swap(arr,rand,start);
        //随机找一个元素
        int pivot = arr[start];
        int left = start;
        int right = end;
        while(left != right){
            while(left < right && arr[right] > pivot){
                right--;
            }
            while(left < right && arr[left] <= pivot){
                left++;
            }
            if(left < right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        arr[start] = arr[left];
        arr[left] = pivot;
        return left;
    }

    public static void swap(int [] arr,int i,int j){
        int p = arr[i];
        arr[i] = arr[j];
        arr[j] = p;
    }
}
