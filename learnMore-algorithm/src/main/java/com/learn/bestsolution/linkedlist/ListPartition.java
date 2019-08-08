package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;

/**
 * 将链表调整为以某值为借左大中等右小的结构   T = O(N)
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/7
 */
public class ListPartition {
    /**
     * 通过插入排序对数组中元素进行重排  插入排序平均时间复杂度为O(N^2) 所以满足要求
     * @param head
     * @param val
     * @return
     */
    public static Node<Integer>  listPartitionByInsertSort(Node<Integer> head,int val){
        if(head == null || head.next == null){
            return head;
        }
        // 求链表长度
        int len = 0;
        Node<Integer> node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        int cap = 0;
        Node<Integer>[] arr = new Node[len];
        while(head != null){
            if(cap == 0){
                arr[cap++] = head;
            }else {
                if(head.value >= val){
                    // 同当前位置的前面位置比较
                    int i = cap - 1;
                    for(;arr[i].value <= val;i--){
                        arr[i+1] = arr[i];
                    }
                    arr[i+1] = head;
                }else {
                    arr[cap] = head;

                }
                cap++;
            }
            head = head.next;
        }
        // arr中的元素还带着next节点！！！！
        for(int i = 0;i < len;i++){
            if(i == 0){
                head = arr[i];continue;
            }
            arr[i-1].next = arr[i];
        }
        arr[len - 1].next = null;
        return head;
    }

    /**
     * 快排思想
     * @param head
     * @param val
     * @return
     */
    public static Node<Integer>  listPartitionByQicklySort(Node<Integer> head,int val){
        if(head == null || head.next == null){
            return head;
        }
        // 求链表长度
        int len = 0;
        Node<Integer> node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        Node<Integer>[] arr = new Node[len];
        int cap = 0;
        while(head != null){
            arr[cap++] = head;
            head = head.next;
        }
        sort(arr,val);
        // arr中的元素还带着next节点！！！！
        for(int i = 0;i < len;i++){
            if(i == 0){
                head = arr[i];continue;
            }
            arr[i-1].next = arr[i];
        }
        arr[len - 1].next = null;
        return head;
    }
    public static void sort(Node<Integer> [] arr,int val){
        int s = -1;
        int e = arr.length;
        int index = 0;
        while(index != e){
            //注意如果发生
            if(arr[index].value > val){
                //交换index和左边大域指针位置交换
            }else if(arr[index].value == val){
                index++;
            }else {            //注意此时idx不增加
                //交换idx和右边小域指针
            }
        }
    }

    public static void main(String[] args) {
        CommonNode.printSingleList(listPartitionByInsertSort(CommonNode.singleHead,6));
    }
}
