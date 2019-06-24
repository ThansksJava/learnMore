package com.learn.practice;

/**
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，
 * 要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/6/21 14:08
 */
public class Juzhen {
    public static int countWays(int x, int y) {
        // write code here
        int[][] dp = new int[x][y];
        dp[0][0] = 1;
        for(int i = 1; i < x; i++){
            dp[i][0] = dp[i-1][0];
        }
        for(int i = 1; i < y; i++){
            dp[0][i] = dp[0][i-1];
        }
        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[x-1][y-1];
    }

    public static void main(String[] args) {
        System.out.println(countWays(3,3));
    }
}
