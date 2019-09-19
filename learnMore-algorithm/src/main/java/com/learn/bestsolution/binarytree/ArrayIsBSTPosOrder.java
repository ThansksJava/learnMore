package com.learn.bestsolution.binarytree;

/**
 * 判断给定的数组是否是搜索二叉树的后序遍历序列
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/9/19
 */
public class ArrayIsBSTPosOrder {
    /**
     * 如果是后序遍历则数组的最后一个元素肯定是根节点，根据搜索二叉树的性质，小于根节点的都是左子树，大于
     * 根节点的都是右子树，由此对子树再进行判断
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static boolean isBSTPosOrder(int[] arr, int start, int end){
        if(start == end){
            return true;
        }
        //数组中左子树最后一个节点的位置
        int less = -1;
        //数组中右子树的第一个节点位置
        int more = end;
        for (int i = start; i < end; i++) {
            if(arr[i] < arr[end]){
                less = i;
            }else{
                //右子树的起始位置应该是第一个大于arr[end]的位置，找到之后就不再变动，判断左子树的节点会一直往后只要遇到小值就会把
                //位置更新，所以如果出现不满足BST性质地数时，less会跑到more里面，也就是不满足条件
                more = more == end? i : more;
            }
        }
        // 说明此序列是一棵只有单子树的数
        if(less == -1 || more == end){
            return isBSTPosOrder(arr,start,end - 1);
        }
        //左子树性质 又按照搜索二叉树的性质，less域最后一个节点应该在more域的前一个位置
        if(less != more - 1){
            return false;
        }
        return isBSTPosOrder(arr,start,less) && isBSTPosOrder(arr, more, end - 1);
    }

    public static Node posArrayToBST(int [] arr,int start,int end){
        if(start > end){
            return null;
        }
        Node head = new Node(arr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if(arr[i] < arr[end]){
                less = i;
            }else{
                more = more == end? i : more;
            }
        }
        head.left = posArrayToBST(arr,start,less);
        head.right = posArrayToBST(arr,more,end-1);
        return head;
    }
}
