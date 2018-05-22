package com.cnpc.sss.newcoder;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/22
 * @Time 17:41
 */
public class PutSmallerLeft {
    public static void putLeft(int [] array,int left,int right){

    }
    public static void swap(int [] array,int i,int j){
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];

    }
    public static void main(String[] args) {

    }
}
