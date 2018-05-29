package com.cnpc.sss.newcoder;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/27
 * @Time 11:25
 */
public class HeapSort {
    /**
     * 新插入一个数后，依次上浮，不断判断与父节点的大小，大于父节点则上浮
     * @param array
     * @param index
     */
    public static void heapInsert(int [] array,int index){
        while(array[index] > array[(index - 1) /2]){
            SortUtils.swap(array,index,(index - 1) /2);
            index = (index - 1) /2;
        }
    }

    public static void heapSort(int [] array){
        if (array == null || array.length < 2){
            return;
        }
        /*从1开始是否有问题？*/
        for (int i = 1;i < array.length;i++){
            heapInsert(array,i);
        }
        int size = array.length;
        /*找到整个数组中最大的一个数*/
        SortUtils.swap(array, 0, --size);
        while (size > 0) {
            /*依次通过堆化排序*/
            heapify(array, 0, size);
            SortUtils.swap(array, 0, --size);
        }
    }
    /**
     * 重新调整为大根堆
     * @param array
     * @param index
     * @param heapSize
     */
    public static void heapify(int [] array,int index,int heapSize){
        int lc = index * 2 + 1;
        while(lc < heapSize){
            int rc = lc + 1;
            /*右孩子的大小不能越界，挑选出两个子节点中较大子节点的下标 TODO 非常之坑的一个地方*/
//            如果这样写就必须先判断右节点下标是否越界才行，不然有可能会把越界的右节点下标赋给largestIndex，然后后面交换就会出错
//            int largeIndex = rc < heapSize && array[lc] > array[rc]?lc:rc;

            int largeIndex = rc < heapSize && array[rc] > array[lc]?rc:lc;

            /*如果子节点不大于当前节点，那么较大值的节点应该改为当前节点*/
            largeIndex = array[largeIndex] > array[index] ? largeIndex:index;
            /*相等直接就结束循环，heapify过程结束*/
            if(largeIndex == index){
                break;
            }
            SortUtils.swap(array,index,largeIndex);
            index = largeIndex;
            lc = index * 2 + 1;
        }
    }

    public static void main(String[] args) {
        boolean flag = true;
        for(int i = 0; i < 100;i++){
            int [] array = SortUtils.generateRandomArray(10,10);
            int [] copyArray = SortUtils.copyArray(array);
            SortUtils.comparator(copyArray);
            heapSort(array);
            if(!SortUtils.isEqual(array,copyArray)){
                flag = false;
                break;
            }
        }
        System.out.println(flag?"succcess":"fuck wrong");
    }
}
