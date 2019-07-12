package com.learn.bestsolution;

/**
 * 汉诺塔
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/6/26 15:46
 */
public class HanoiTower {
    /**
     * 汉诺塔
     * @param num
     */
    public static void hanoiProblem1(int num){
        if(num > 0){
            func(num,"left","mid","right");
        }
    }

    /**
     * 必须经过中间
     * @param num
     */
    public static void hanoiProblem2(int num){

    }

    /**
     * TODO 2019年7月12日10:24:00 感觉难度略大，看都看不下去以后再写
     * @param num
     * @param left
     * @param mid
     * @param right
     * @param from
     * @param to
     * @return
     */
    public static int process(int num,String left,String mid,String right,String from,String to){
       if(num == 1){
           if(from.equals(mid) || to.equals(mid)){
               System.out.println("move 1 from "+from+" to "+to);
               return 1;
           }else {
               System.out.println("move 1 from "+from+" to "+mid);
               System.out.println("move 1 from "+mid+" to "+to);
               return 2;
           }
       }
       if(from.equals(mid) || to.equals(mid)){
           String another = (from.equals(left) || to.equals(left)) ? right : left;
           int part1 = process(num - 1,left,mid,right,another,to);
           int part2 = 1;
           System.out.println("move " + num + "from" + from + "to " + to );
           int part3 = process(num - 1,left,mid,right,another,to);
       }
       return 0;
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



