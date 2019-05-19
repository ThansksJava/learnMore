package com.learn.leetcode;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/6
 * @Time 9:57
 */
public class AddTwoNumber {
  static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode rhead = result;
        ListNode head1 = l1;
        ListNode head2 = l2;
        int jw = 0;
        while(head1 != null && head2 != null){
            int add = head1.val+head2.val+jw;
            jw = 0;
            if(add >= 10){
                jw = add / 10;
                result.val = add % 10;
            }else{
                result.val = add;
            }
            result.next = (head1.next != null ||  head2.next != null)? new ListNode(0):null;
            if (result.next != null){
                result = result.next;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        ListNode head3 = (head1==null?head2:head1);
        while(head3 != null){
            int add = head3.val+jw;
            jw = 0;
            if(add >= 10){
                jw = add / 10;
                result.val = add % 10;
            }else{
                result.val = add;
            }
            result.next = head3.next == null? null : new ListNode(0);
            if(result.next != null){
                result = result.next;
            }
            head3 = head3.next;
        }
        if (jw != 0){
            result.next = new ListNode(jw);
        }
        return rhead;
  }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
//        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(node1,node2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}