package com.learn.practice;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/6/19 16:13
 */
public class BinarySearch {
    public static int search(int [] arr,int target){
        //没找到
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
//            int mid = left + (right-left)/2;
            int mid = left + ((right-left) >> 1);
            int midValue = arr[mid];
            if(midValue > target){
                right = mid - 1;
            }else if(midValue < target){
                left = mid + 1;
            }else {
                index = mid;break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 2;
        System.out.println(search(array,target));
    }
}
