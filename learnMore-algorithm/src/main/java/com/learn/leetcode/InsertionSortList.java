package com.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2020/1/7
 */
public class InsertionSortList {

      static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //把所有的node放入list
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        list.add(null);
        //得到个数，像数组一样排序
        int size = list.size();
        for(int i = 1;i < size - 1;i++){
            int j = i;
            ListNode cur = list.get(i);
            while(j > 0 && cur.val < list.get(j-1).val){
                list.set(j,list.get(j-1));
                j--;
            }
            list.set(j,cur);
        }
        for(int i = 1;i < size;i++){
            list.get(i-1).next = list.get(i);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode x = new ListNode(2);
        ListNode y = new ListNode(1);
        ListNode z = new ListNode(3);
        head.next = x;
        x.next = y;
        y.next = z;
        insertionSortList(head);
    }
}
