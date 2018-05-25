package com.cnpc.sss.newcoder;

import java.util.Arrays;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/25
 * @Time 9:15
 */

/**
 * 复杂度分析
 * 
 */
public class HelanFlag {
    public static void sort(int [] array,int target){
        int index = 0;
        /*小域*/
        int less = index-1;
        /*大域*/
        int more = array.length;
        /*index <= more 的问题是index位置的数会跟equal域或者less域交换,感觉自己好傻逼*/
        while(index < more){
            if(array[index] < target){
                SortUtils.swap(array,index++,++less);
            }
            else if (array[index] > target){
                SortUtils.swap(array,index,--more);
            }else {
                index++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {
        int [] array = {5,7,6,4,8,3,9,6};
        int target = 6;
        sort(array,target);
    }
}
