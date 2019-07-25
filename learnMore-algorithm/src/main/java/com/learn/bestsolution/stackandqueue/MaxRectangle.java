package com.learn.bestsolution.stackandqueue;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 * @author fengjie
 * @version 1.0
 * @date Created in 2019年7月22日11:25:44
 */
public class MaxRectangle {
    public static int maxRec(int [][] rec){
        if(rec == null || rec.length == 0 && rec[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int [] height = new int [rec[0].length];
        for(int i = 0;i < rec.length;i++){
            for(int j = 0;j < rec[i].length;j++){
                height[j] = rec[i][j] == 0 ? 0 : height[j] + 1;
                maxArea = Math.max(maxRecFromBottom(height),maxArea);
            }
        }
        return maxArea;
    }
    public static int maxRecFromBottom(int [] height){
        if(height.length == 0 || height == null){
            return 0;
        }
        int maxArea = 0;
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < len;i++){
            if(stack.isEmpty() || height[stack.peek()] <= height[i]){
                stack.push(i);
            }else {
                while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                    int j = stack.pop();
                    //判断此时栈是否已空
                    int k = stack.isEmpty()?-1:stack.peek();
                    int curRec = (i - k - 1) * height[j];
                    maxArea = Math.max(curRec,maxArea);
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty()?-1:stack.peek();
            //此时每个元素的右边界都是数组的最后一个元素位置
            int curRec = (height.length - k - 1) * height[j];
            maxArea = Math.max(curRec,maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [][] rec = {
                {1,1,1,1},
                {1,0,1,1},
                {1,1,0,0}
        };
        System.out.println(maxRec(rec));
    }
}
