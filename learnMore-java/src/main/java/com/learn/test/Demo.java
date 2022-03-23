package com.learn.test;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        int [] integers = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, integers));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if(nums == null || target < 0){
            return 0;
        }
        int minLength = Integer.MAX_VALUE;
        // 挨个求吧就
        for(int i = 0; i < nums.length; i++){
            // 如果第一个值就命中了那最小就是1
            int sum = nums[i];
            // 定义count = 1,下面开始循环，每加一个数就增加1，直到已经大于或者等于target
            int count = 1;
            for(int j = i + 1; j < nums.length; j++){
                // 如果大于命中值了，说明此次循环可以结束了，没有相加等于target的值
                if(sum >= target){// 如果此时出现等于的值，那么此次循环中等于target的值找到了
                    minLength = Math.min(minLength, count);
                    break;
                }

            }
        }
        return minLength == Integer.MAX_VALUE? 0: minLength;
    }
}