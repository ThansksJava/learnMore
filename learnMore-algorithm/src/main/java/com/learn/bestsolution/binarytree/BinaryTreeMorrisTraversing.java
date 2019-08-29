package com.learn.bestsolution.binarytree;

/**
 * TODO morris遍历二叉树
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/23
 */
public class BinaryTreeMorrisTraversing {
    /**
     * 先序遍历二叉树
     * @param root
     */
    public static void preOrder(Node root){
        if(root == null){
            System.out.println("null");
        }
        Node help = null;
        while (root != null){
            if(root.left == null){
                root.right = root;
            }
            else {
                root = root.left;
            }
        }
    }

    /**
     * 中序遍历二叉树
     * @param root
     */
    public static void inOrder(Node root){
        if(root == null){
            System.out.println("null");
        }
        Node cur1 = root;
        Node cur2 = null;
        while(cur1 != null){
            cur2 = cur1.left;
            //找到当前cur1的最右的子节点
            //        1
//                 2       3
//               4
//             5  6            cur2.right != cur1
            if(cur2 != null){
                while(cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                //将当前cur1的最右子节点的右指针指向当前cur1
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;

                }
                //等到往回返的时候就会执行到这一步，把之前右指针重新置空
                else{
                    cur2.right = null;
                }
            }
            System.out.print(cur1.value + " ");
            cur1 = cur1.right;
        }

    }
    /**
     * 后序遍历二叉树
     * @param root
     */
    public static void posOrder(Node root){
        if(root == null){
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        inOrder(n1);
    }
}
