package com.learn.newcoder;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/6/4
 * @Time 10:29
 */
public class Zhuanquandayin {
    public static void spiralOrderPrint(int [][] a){
        int tx = 0;
        int ty = 0;
        int bx = a.length-1;
        int by = a[0].length - 1;
        while(tx <= bx && ty <= by){
            print(a,tx++,ty++,bx--,by--);
        }
    }

    public static void print(int [][] a,int tx,int ty,int bx,int by ){
        if(tx ==bx){
            for(int i = ty;i <= by;i++){
                System.out.print(a[tx][i]+",");
            }
            return;
        }
        if(ty == by){
            for (int i = tx;i <= bx;i++){
                System.out.print(a[i][ty]+",");
            }
            return;
        }
        for(int i = ty;i < by;i++){
            System.out.print(a[tx][i]+",");
        }
        for(int i = tx;i < bx;i++){
            System.out.print(a[i][by]+",");
        }
        for(int i = by;i > ty;i--){
            System.out.print(a[bx][i]+",");
        }
        for (int i = bx; i > tx;i--){
            System.out.print(a[i][ty]+",");
        }

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int[][] matrix1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }};
        spiralOrderPrint(matrix);
        System.out.println("==============================");
        spiralOrderPrint(matrix1);
    }
}
