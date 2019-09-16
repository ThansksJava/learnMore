package com.learn.bestsolution.sort;

import com.learn.newcoder.SortUtils;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/16
 */
public class HeapSort {
    public static void heapInsert(int [] arr,int idx){
        //如果元素大于其父节点，则交换父节点值跟idx值
        while(arr[idx] > arr[(idx - 1) / 2]){
            swap(arr,idx,(idx - 1) / 2);
            //交换完毕后此时原idx位置的元素到了父节点位置，继续进行上浮
            // 判断此时父节点和父节点的父节点
            idx = (idx - 1) / 2;
        }
    }
    public static void headSort(int [] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int size = arr.length;
        /*找到整个数组中最大的一个数*/
        SortUtils.swap(arr, 0, --size);
        while (size > 0) {
            /*依次通过堆化排序*/
            heapify(arr, 0, size);
            SortUtils.swap(arr, 0, --size);
        }
    }
    public static void heapify(int [] arr,int idx,int heapSize){
        int lc = idx * 2 + 1;
        while(lc < heapSize){
            int rc = lc + 1;
            int largeIdx = rc < heapSize && arr[rc] > arr[lc] ? rc : lc;
            largeIdx = arr[largeIdx] > arr[idx] ? largeIdx : idx;
            if (largeIdx == idx){
                break;
            }
            swap(arr,idx,largeIdx);
            lc = idx * 2 + 1;
        }
    }


    public static void main(String[] args) {
        int [] arr = generateRandomArray(10,20);
        headSort(arr);

    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void swap(int [] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
