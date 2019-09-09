package com.learn.bestsolution.sort;

/**
 * 冒泡排序
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/9
 */
public class BubbleSort {
    public static int [] bubbleSort(int[] arr){
        //标记是否有序
        boolean isSorted = true;
        int lastExchangeIndex = 0;
        int sortedBorder = arr.length - 1;
        for(int i = 0;i < arr.length - 1;i++){
            for (int j = 0; j < sortedBorder; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j] = tmp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortedBorder = lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
        return arr;
    }

}
