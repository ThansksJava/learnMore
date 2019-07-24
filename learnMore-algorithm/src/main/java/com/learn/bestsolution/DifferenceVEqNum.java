package com.learn.bestsolution;

import java.util.LinkedList;
import java.util.List;

/**
 * 求最大值最小值小于或者等于特定num的数组的子数组的数目
 * @author fengjie
 * @version 1.0
 * @date Created in 2019年7月24日14:00:17
 */
public class DifferenceVEqNum {
    /**
     * 解答
     * @param arr 数组
     * @param num 目标值
     * @return 子数组数量
     */
    public static int getNum(int [] arr,int num){
        if(arr == null  || arr.length == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        int res = 0;
        int len = arr.length;
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();

        while(i < len){
            while(j < len){
                while(!max.isEmpty()&& arr[max.peekLast()] <= arr[j]){
                    max.pollLast();
                }
                max.addLast(j);

                while(!min.isEmpty() && arr[min.peekLast()] >= arr[j]){
                    min.pollLast();
                }
                min.addLast(j);
                if((arr[max.getFirst()] - arr[min.getFirst()]) > num){
                    break;
                }
                j++;
            }
            if(min.peekFirst() == i){
                min.pollFirst();
            }
            if(max.peekFirst() == i){
                max.pollFirst();
            }
            res += j - i;
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int [] arr = {8,6,10,17,5,20,19};
        System.out.println(getNum(arr,5));
    }
}
