package com.learn.bestsolution;

/**
 * 汉诺塔
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/6/26 15:46
 */
public class HanoiTower {
    public static void hanoiProblem1(int num){
        if(num > 0){
            func(num,"left","mid","right");
        }
    }

    public static void func(int n,String from,String mid,String to){
        if(n == 1){
            System.out.println("move from "+from+" to "+to);
        }else{
            //把最底下一层上面的所有从 左 -> 中
            func(n-1,from,to,mid);
            //把最后一层从 左 -> 右
            func(1,from,mid,to);
            //把其他从 中 -> 右
            func(n-1,mid,from,to);
        }
    }

    public static void main(String[] args) {
        hanoiProblem1(1);
        System.out.println("====");
        hanoiProblem1(2);
        System.out.println("====");
        hanoiProblem1(3);
    }
}



