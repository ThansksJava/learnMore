package com.cnpc.sss.newcoder;

/**
 * @Author fengjie
 * @Description 先确定对角线两点，再进行打印，由上到下后由下到上，用boolean值来控制
 * @Date Created in 2018/6/15
 * @Time 9:39
 */
public class MatrixZhiPrint {
    public static void print(int [][] m,int a,int b,int c,int d){
        while(a++ < m.length )
        printDiagonalLine(m, a, b, c, d);

    }
    public static void printDiagonalLine(int [][] m,int a,int b,int c,int d){
        while(a >= c && b <= d){
            System.out.print(m[a--][b++]);
        }
    }

    public static void main(String[] args) {
        int [][] a = new int [4][4];
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4;j++){
                a[i][j] = i+j;
            }
        }
        printDiagonalLine(a,0,0,0,0);
    }
}
