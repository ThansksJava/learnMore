package com.cnpc.sss.swordtooffer;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/9/27
 * @Time 21:32
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int index = str.indexOf(" ");
        while(index > 0){
            str.replace(index,index+1,"%20");
            index = index+3;
            StringBuffer sub = new StringBuffer(str.substring(index));

        }
        return str.toString();
    }
}
