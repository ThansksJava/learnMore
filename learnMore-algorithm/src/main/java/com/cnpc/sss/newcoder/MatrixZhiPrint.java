package com.cnpc.sss.newcoder;

/**
 * @Author fengjie
 * @Description 先确定对角线两点，再进行打印，由上到下后由下到上，用boolean值来控制
 * @Date Created in 2018/6/15
 * @Time 9:39
 */
public class MatrixZhiPrint {
    public static void print(int [][] m){
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        /*设置true表示从上向下打印*/
        boolean flag = true;
        int row = m.length-1;
        int column = m[0].length-1;
        while(a != row+1){
            printDiagonalLine(m,a,b,c,d,flag);
            /*如果上坐标到了最最右边那么就往下移动*/
            a = b == column ? a + 1 : a;
            b = b == column ? b : b + 1;
            d = c == row ? d + 1 : d;
            c = c == row ? c : c + 1;
            flag = !flag;
        }

    }
    public static void printDiagonalLine(int [][] m,int a,int b,int c,int d,boolean flag){
        if (flag) {
            while (a != c + 1) {
                System.out.print(m[a++][b--] + " ");
            }
        } else {
            while (c != a - 1) {
                System.out.print(m[c--][d++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int [][] a = {{1,4,5,7},{2,6,9,1},{3,8,2,5},{7,9,4,3}};
        print(a);
    }
}
