package com.learn.swordtooffer;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/6
 */
public class XuanzhuanArray {
    public static int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int p1 = 0;
        int p2 = array.length - 1;
        while(array[p1] >= array[p2]){
            if(p2 - p1 == 1){
                break;
            }
            int mid = (p1+p2) >> 1;
            //说明这个mid位置的元素位于前半个递增数组，
            //p1的位置肯定>=后面数组的任意一个元素
            if(array[mid] >= array[p1]){
                p1 = mid;
            }//说明mid位置元素位于后面递增序列中最小值位置 <= mid
            else if(array[mid] <= array[p2]){
                p2 = mid;
            }
        }
        return array[p2];
    }

    public static void main(String[] args) {
        int [] array = {6501,6828,6963,7036,7422,7674,
                8146,8468,8704,8717,9170,9359,9719,9895,
                9896,9913,9962,154,293,334,492,1323,1479,1539,
                1727,1870,1943,2383,2392,2996,3282,3812,3903,
                4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(minNumberInRotateArray(array));
    }
}
