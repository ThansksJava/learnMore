package com.cnpc.sss.swordtooffer;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/2/26 11:19
 */
public class MergeSortedList {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    private ListNode merge(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergeList = null;
        ListNode sList1 = list1;
        ListNode sList2 = list2;
        if(sList1.val < sList2.val){
            mergeList = sList1;
            mergeList.next = merge(sList1.next,sList2);
        }
        else{
            mergeList = sList2;
            mergeList.next = merge(sList1,sList2.next);
        }
        return mergeList;
    }

    public static void main(String[] args) {

    }
}
