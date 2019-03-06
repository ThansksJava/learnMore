package com.cnpc.sss.swordtooffer;

import com.cnpc.sss.newcoder.SortUtils;

import java.util.Arrays;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/3/1 14:45
 */
public class InsertionSort {
    /**
     * 插入排序，洗牌摸牌插牌
     * @param array 待排序数组
     */
    private static int []  sort(int [] array){
        if(array == null || array.length == 0){
            return array;
        }
        int length = array.length;
        for(int i = 1;i < length;i++){
            int x = array[i];
            int j = i-1;
            for(;j >= 0;j--){
                if(array[j] > x){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = x;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100;i++){
            int [] array = SortUtils.generateRandomArray(10,9);
            System.out.println(Arrays.toString(array));
            Arrays.sort(array);
            int [] sorted = sort(array);
            if(!SortUtils.isEqual(array,sorted)){
                System.out.println("fuck wrong");
                break;
            }

        }
    }
}
