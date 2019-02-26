package com.cnpc.sss.swordtooffer;

/**
 * 检查是否有环、返回环的位置、环的节点数量
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/2/26 13:56
 */
@SuppressWarnings("Duplicates")
public class CheckTheRing {
    private static int checkRing(Node head){
        if(head == null){
            return 0;
        }
        if(head.next == null){
            System.out.println("没有环");
            return 0;
        }
        Node s = head;
        Node f = head;
        while(f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f){
                System.out.println("有环");
                Node q = s;
                int n = 1;
                while(s.next != q){
                    n++;
                    s = s.next;
                }
                System.out.println(n);
                return n;
            }
        }
        System.out.println("梅友欢");
        return 0;
    }
    private static Node checkRingStartPosition(Node head,int n){
        Node s = head;
        Node f = head;
        int i = 1;
        while(i++ <= n){
            f = f.next;
        }
        while(f != s){
            s = s.next;
            f = f.next;
        }
        return s;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
//        Node node8 = new Node(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node3;
        Node node = checkRingStartPosition(node1,checkRing(node1));
        System.out.println(node.value);

    }
}
