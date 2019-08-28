package com.learn.bestsolution.binarytree;

/**
 * 打印边界节点
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/26
 */
public class PrintNodeAtEdge {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        Node n15 = new Node(15);
        Node n16 = new Node(16);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n5.left = n9;
        n5.right = n10;
        n8.right = n11;
        n9.left = n12;
        n11.left = n13;
        n11.right = n14;
        n12.left = n15;
        n12.right = n16;

        printEdge1(n1);
    }

    public static void printEdge1(Node head){
        if(head == null){
            return;
        }
        int height = getHeight(head,0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head,0,edgeMap);
        //打印左边界
        for(int i = 0;i != edgeMap.length;i++){
            System.out.println(edgeMap[i][0].value + " ");
        }
        //打印各层非最左最右的叶子节点
        printLeafNotInMap(head,0,edgeMap);
        //打印右边界，但不是左边界的节点
        for(int i = edgeMap.length - 1;i != -1;i--){
            //只有根节点是相等的，因为只有一个元素
            if(edgeMap[i][0] != edgeMap[i][1]){
                System.out.println(edgeMap[i][1].value + " ");
            }
        }
    }
    /**
     * 得到高度
     * @param h
     * @param l
     * @return
     */
    public static int getHeight(Node h,int l){
        if(h == null){
            return l;
        }
        return Math.max(getHeight(h.left,l+1),getHeight(h.right,l+1));
    }

    /**
     * 存储各层最左和最右节点
     * @param h
     * @param curLevel
     * @param edgeMap
     */
    public static void setEdgeMap(Node h,int curLevel,Node[][] edgeMap){
        if(h == null){
            return;
        }
        //先把左节点放上，递归过程中逐渐把各层右节点放上
        edgeMap[curLevel][0] = edgeMap[curLevel][0] == null?h:edgeMap[curLevel][0];
        edgeMap[curLevel][1] = h;
        setEdgeMap(h.left,curLevel + 1,edgeMap);
        setEdgeMap(h.right,curLevel+1,edgeMap);
    }
    public static void printLeafNotInMap(Node h,int curLevel,Node [][] m){
        if(h == null){
            return;
        }
        if(h.left == null && h.right == null && h != m[curLevel][0] && h != m[curLevel][1]){
            System.out.println(h.value+" ");
        }
        printLeafNotInMap(h.left,curLevel+1,m);
        printLeafNotInMap(h.right,curLevel+1,m);
    }
}
