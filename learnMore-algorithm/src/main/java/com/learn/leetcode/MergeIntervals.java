package com.learn.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2020/1/6
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        //空指针和元素为0返回空数组
        if(intervals == null || intervals.length==0){
            return new int[0][0];
        }
        int len = intervals.length;
        //元素个数是1直接返回
        if(len==1){
            return intervals;
        }
        // //先将intervals按照一维数组排序
        // for(int i = 1;i < len;i++){
        //     int [] cur = intervals[i];
        //     int j = i-1;
        //     for(;j >= 0;j--){
        //         if(cur[0] < intervals[j][0]){
        //             intervals[j+1] = intervals[j];
        //         }else{
        //             break;
        //         }
        //     }
        //     intervals[j+1] = cur;
        // }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> s = new Stack<>();
        s.push(intervals[0]);
        for(int i = 1; i < len;i++){
            int [] top = s.peek();
            //如果栈首数组1位置 < intervals[i][0]说明无交集
            if(top[1] < intervals[i][0]){
                s.push(intervals[i]);
                //top[1] >= intervals[i][0] 有点多余了
            }else if(top[1] >= intervals[i][0] && top[1] < intervals[i][1]){
                top[1] = intervals[i][1];
                s.pop();
                s.push(top);
            }
        }
        int [][] ret = new int[s.size()][];
        int i = 0;
        while(!s.empty()){
            ret[i++]=s.pop();
        }
        return ret;
    }
}
