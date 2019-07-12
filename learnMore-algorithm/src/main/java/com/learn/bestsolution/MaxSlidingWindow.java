package com.learn.bestsolution;

import java.util.ArrayDeque;

/**
 * 滑动窗口最大值 TODO 再看看吧还是
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/6/25 10:08
 */
public class MaxSlidingWindow {
    public static int [] maxSlidingWindow(int [] nums,int k){
        if(nums == null && nums.length == 0){
            return new int [0];
        }
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int  len = nums.length;
        for(int i = 0;i < len;i++){
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(deque.getFirst() == i - k){
                deque.removeFirst();
            }
            if(i >= k - 1){
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
