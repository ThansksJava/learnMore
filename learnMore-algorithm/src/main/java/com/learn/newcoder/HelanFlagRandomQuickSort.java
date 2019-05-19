package com.learn.newcoder;

import java.util.Arrays;

/**
 * 左程云老师是随机选择一个数跟最后一个数交换然后进行切分，我这样写应该效果一样吧
 * 长期期望：O(logN)
 */
@SuppressWarnings("Duplicates")
public class HelanFlagRandomQuickSort {
    public static void quickSort(int [] array,int start,int end){
        if(array == null || array.length < 2){
            return;
        }
        if (start < end){
            int target = array[start+ (int)(Math.random()*(end - start + 1))];
            int [] location = partition(array,start,end,target);
            quickSort(array,start,location[0]);
            quickSort(array,location[1],end);
        }

    }
    public static int [] partition(int [] array,int start,int end,int target){
        int less = start - 1;
        int more = end + 1;
        int index = start;
        while(index < more){
            if(array[index] < target){
                SortUtils.swap(array,++less,index++);
            }else if(array[index] > target){
                SortUtils.swap(array,--more,index);
            }else {
                index++;
            }

        }
        return new int[]{less,more};
    }

    public static void main(String[] args) {
        boolean flag = true;
        for(int i = 0;i < 100;i++){
            /*数组是引用传递*/
            int [] array = SortUtils.generateRandomArray(10,10);
            int [] copy = SortUtils.copyArray(array);
            quickSort(array,0,array.length-1);
            SortUtils.comparator(copy);
            System.out.println("第"+i+"次"+Arrays.toString(array));
            if(!SortUtils.isEqual(array,copy)){
                 flag = false;
                 break;
            }
        }
        System.out.println(flag==true?"success":"fuck wrong");
//        int [] array = {0,0,-1,3,4};
//        quickSort(array,0,4);
//        System.out.println(Arrays.toString(array));

    }
}
