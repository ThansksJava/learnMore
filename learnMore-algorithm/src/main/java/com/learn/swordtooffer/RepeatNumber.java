package com.learn.swordtooffer;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/5/24
 */
public class RepeatNumber {
    public int findRepeatNumber(int[] nums) {
        //参考题解：所有数字都在0 ~ n-1 范围内
        int length = nums.length;
        int [] location = new int[length];
        for(int i = 0;i < length;i++){
//            location[nums[i]] += 1;
            location[nums[i]]++;
            if(location[nums[i]] > 1){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] num = new int[2];
        num[1]++;
        System.out.println(num[1]);
    }
}
