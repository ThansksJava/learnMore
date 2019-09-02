package com.learn.bestsolution.binarytree;

/**
 * 二叉树符合拓扑结构的最大结构
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/2
 */
public class BiggestBSTTOPO {
    public static int bstTopoSize(Node head){
        if(head == null){
            return 0;
        }
        int max = maxTopo(head,head);
        max = Math.max(bstTopoSize(head.left),max);
        max = Math.max(bstTopoSize(head.right),max);
        return max;
    }
    public static int maxTopo(Node h,Node n){
        if(h != null && n != null && isBSTNode(h,n,n.value)){
            return maxTopo(h,n.left)+maxTopo(h,n.right)+1;
        }
        return 0;
    }

    /**
     * 是否是拓扑结构
     * @param h 当前树头结点
     * @param n 遍历到的子节点
     * @param value n的值
     * @return 结果是否是拓扑
     */
    public static boolean isBSTNode(Node h,Node n,int value){
        if(h == null){
            return false;
        }
        if(h == n){
            return true;
        }
        return isBSTNode(h.value > value?h.left:h.right,n,value);
    }
}
