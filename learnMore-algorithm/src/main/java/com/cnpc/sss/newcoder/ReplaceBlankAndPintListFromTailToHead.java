package com.cnpc.sss.newcoder;

import java.util.ArrayList;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/17 21:08
 */
public class ReplaceBlankAndPintListFromTailToHead {
    static class ListNode {
    int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static String replaceSpace(StringBuffer str) {
        StringBuffer str1 = new StringBuffer();
        char [] chars = str.toString().toCharArray();
        for(int i = 0;i < chars.length;i++){
            if(chars[i]==' '){
                str.append("%20");
            }else{
                str.append(chars[i]);
            }
        }
        return str1.toString();
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){
            return list;
        }
        ListNode p = listNode;
        while(p.next != null){
            ListNode q = p.next;
            ListNode x = q;
            q.next = p;
            p = x;
        }
        listNode.next = null;
        while(listNode.next != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
    public static void main(String[] args) {
        StringBuffer sql = new StringBuffer();
        sql.append("hello world");

        System.out.println(replaceSpace(sql));

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printListFromTailToHead(node1);
    }
}
