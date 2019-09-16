package com.learn.bestsolution.binarytree;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/11
 */
public class ContainsOtherTreeTOPO {
    public static boolean contains(Node t1,Node t2){
        return check(t1,t2) || contains(t1.left,t2) || contains(t1.right,t2);
    }
    public static boolean check(Node t1,Node t2){
        if(t2 == null){
            return true;
        }
        if(t1 == null || t1.value != t2.value){
            return false;
        }
        return check(t1.left,t2.left) && check(t1.right,t2.right);
    }
}
