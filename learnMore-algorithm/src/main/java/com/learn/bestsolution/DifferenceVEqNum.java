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
        //从i(子数组的起始位置)开始到j（子数组的结束位置）
        //i到j之间的最大值与最小值放入两个双端队列
        //每次j挪动一个位置都要判断一下此时的最大值与最小值，如果当前j位置最大最小值差值已经大于给定数值了则停下
        //此时以i开头的子数组数目为 j-i ex:1,2,3...   1,2  1,2,3
        //i挪动一个位置以后进入下一个循环，从i+1  到  j=j+x ,到原来的j位置显然最大值最小值已经入栈，直接从j+1开始判断就行了
        //也就是说所有的位置最多只进出队列一次 所以时间复杂度稳定在O(n)
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
            //当遍历到起始位置i在队列中，则需要移除之
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
