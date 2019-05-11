package com.cnpc.sss.practice;

/**
 * 沙雕。三个奇数相加还算个球啊，令人忧伤的数学能力
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/11 13:27
 */
public class ThreeNumberToEq30 {
    public static void main(String[] args) {
        int [] a = new int[]{1,3,5,7,9,11,13,15};
        for(int i = 0;i < a.length;i++){
            for(int j = 0;j < a.length;j++){
                for(int z = 0;z < a.length;z++){
                    if(a[i] + a[j]+a[z] == 30){
                        System.out.println(a[i]);
                        System.out.println(a[j]);
                        System.out.println(a[z]);
                    }
                }
            }
        }
    }
}
