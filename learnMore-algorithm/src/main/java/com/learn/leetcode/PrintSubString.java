package com.learn.leetcode;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/16
 * @Time 19:18
 */
public class PrintSubString {
    public static void printSubString(char [] charArray,int index,String res){
        if(index == charArray.length){
            System.out.println(res);
            return;
        }
        printSubString(charArray,index+1,res);
        printSubString(charArray,index+1,res+String.valueOf(charArray[index]));
    }

    public static void main(String[] args) {
        String str = "abc";
        printSubString(str.toCharArray(),0,"");
    }
}
