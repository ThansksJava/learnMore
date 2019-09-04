package com.learn.bestsolution.binarytree;

/**
 * 二叉树中符合BST的最大拓扑结构
 * 按照二叉树的规则进行遍历
 * L.v < H.v && R.v > H
 * 那么取出一个节点记为C,头结点记为H,根据规则C.value < H.value 那么H将向左子树移动，反之，向右子树移动
 * 如果C可以作为BST的节点，那么将会C == H ,遍历到最后都没找到满足情况的节点，那么说明C不能构成BST，返回false
 * 综上所述，每一个节点都要从头遍历一次，O(n^2)
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

    /**
     * 最大的BST拓扑
     * @param h
     * @param n
     * @return
     */
    public static int maxTopo(Node h,Node n){
        //h在后面的循环不变
        if(h != null && n != null && isBSTNode(h,n,n.value)){
            return maxTopo(h,n.left)+maxTopo(h,n.right)+1;
        }
        return 0;
    }

    /**
     *
     * @param h 当前树头结点
     * @param n 遍历到的子节点
     * @param value n的值
     * @return 结果是否是符合BST
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

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        Node n5 = new Node(5);
//        Node n6 = new Node(6);
//        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
//        n3.left = n6;
//        n3.right = n7;

        int x = bstTopoSize(n1);
        System.out.println(x);
    }
}
