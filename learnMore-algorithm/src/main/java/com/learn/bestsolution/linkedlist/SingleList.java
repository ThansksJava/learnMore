package com.learn.bestsolution.linkedlist;

import com.learn.common.Node;
/**
 * 有环无环相交问题
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/12
 */
public class SingleList {
    /**
     * 使用快慢指针判断是否有环,并且返回相交节点
     * @param head
     * @return
     */
    public static Node<Integer> checkTheRing(Node<Integer> head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node<Integer> slow = head.next;
        Node<Integer> fast = head.next.next;
        //如果有环一定会相交
        while(slow != fast){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("有环");
        //fast回到链表头然后同slow一起每次一步向前走那么下次相交就是环的入口
        fast = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 判断两个无环链表是否相交，相交返回交叉点
     * 相交则尾节点相等
     * 然后利用长度差找相交点
     * @param head1
     * @param head2
     * @return
     */
    public static Node<Integer> twoNoLoopListIntersect(Node<Integer> head1,Node<Integer> head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node<Integer> cur1= head1;
        Node<Integer> cur2= head2;
        int len1 = 0;
        int len2 = 0;
        while(cur1.next != null){
            len1++;
            cur1 = cur1.next;
        }
        while(cur2.next != null){
            len2++;
            cur2 = cur2.next;
        }
        if(cur1 == cur2){
            System.out.println("相交");
        }else {
            System.out.println("不相交");
            return null;
        }
        int diff = len1 - len2;

        cur1 = diff > 0?head1:head2;
        cur2 = cur1 == head1?head2:head1;

        diff = Math.abs(diff);
        while(diff != 0){
            diff--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    public static Node<Integer> EntryNodeOfLoop(Node<Integer> head)
    {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node<Integer> fast = head.next;
        Node<Integer> slow = head.next.next;
        while(fast != slow){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 求两个有环链表的相交点
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static Node<Integer> bothLoop(Node<Integer> head1,Node<Integer> loop1,Node<Integer> head2,Node<Integer> loop2){
        Node<Integer> cur1 = null;
        Node<Integer> cur2 = null;
        //
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ?head1:head2;
            cur2 = cur1 == head1?head2:head1;
            n = Math.abs(n);
            // 长的链表先向前走到跟短链表相同的长度位置
            while(n != 0){
                n--;
                cur1 = cur1.next;
            }

            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        //
        else{
            cur1 = loop1.next;
            while(cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
            }
            return null;
        }
    }
    public static void main(String[] args) {
        Node<Integer> node = new Node(9);
        Node<Integer> node1 = new Node(7);
        Node<Integer> node2 = new Node(6);
        Node<Integer> node3 = new Node(10);
        Node<Integer> node4 = new Node(12);
        Node<Integer> node5 = new Node(15);
        Node<Integer> node6 = new Node(13);
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;

        node6.next = node4;
        System.out.println(EntryNodeOfLoop(node).value);
    }
}
