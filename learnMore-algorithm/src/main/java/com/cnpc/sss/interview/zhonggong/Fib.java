package com.cnpc.sss.interview.zhonggong;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 16:30
 */
public class Fib {
    private static final int N=30;
    private static int getFib(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return getFib(n - 1) + getFib(n - 2);
        }
    }

    public static void main(String[] args) {
        for (int i = 1;i <= N;i++){
            System.out.print(getFib(i));
            System.out.print(" ");
        }
    }
}
