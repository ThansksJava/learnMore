package com.learn.bestsolution.binarytree;

import java.util.Queue;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/24
 */
public class IsBSTAndIsCBT {
    public static boolean isBST(Node head){
        if(head == null){
            return true;
        }
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while(cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while(cur2.left != null && cur2.right != null){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }
            }
            if(pre != null && pre.value > cur1.value){
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    public static boolean isCBT(Node head){
        if (head == null){
            return true;
        }
//        Queue
        return false;
    }
}
