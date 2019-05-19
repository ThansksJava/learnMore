package com.learn.interview.interview_zhonggong;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/8 17:36
 */
public class Solution1 {

    public static int getResult(){
        int value = 0;
        try {
            value = value++;
            return value;
        } finally {
            value++;
        }
    }
    public static int getResult1(){
        int value = 0;
        try {
            value = value++;
            return value;
        } finally {
            return value--;
        }
    }


    public static void main(String[] args) {
//        Thread.currentThread().interrupt();
//        if(Thread.currentThread().isInterrupted()){
//
//        }else {
//            System.out.println();
//        }
        System.out.println(getResult());
        System.out.println(getResult1());
    }
}
