package com.learn.bestsolution;

import com.learn.common.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 构造一个
 * <i>不重复</i>数字数组的maxtree
 * @author fengjie
 * @version 1.0
 * @date Created in 2019年7月18日08:42:33
 */
public class ArrayMaxTree {
    public static Node getMaxTree(int [] arr){
        //待返回根节点
        Node head = null;
        int len = arr.length;
        Node [] nodes = new Node[len];
        int index = 0;
        for(int i : arr){
            nodes[index++] = new Node(i);
        }
        Map<Node,Node> LMaxMap = new HashMap<>();
        Map<Node,Node> RMaxMap = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        //要找到每一个元素左侧比它大的第一个数和右侧比它大的第一个数
        //所以入栈规则是：
        // 1、空栈直接入栈
        // 2、入栈元素小于当前栈顶元素则直接入栈
        // 3、入栈元素大于当前栈顶元素，则进入方法：求目前栈顶元素的左侧（或者右侧）第一个比它的数过程见代
        //    码，这个过程一定是对的，挨个跟待入栈元素比较，如果有大于当前待入栈元素的值，那么循环就终止了
        for(int i = 0;i < len;i++){
            Node nNode = nodes[i];
            while(!stack.isEmpty() && (int)stack.peek().value < (int)nNode.value ){
                popStackSetMap(stack,LMaxMap);
            }
            stack.push(nNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack,LMaxMap);
        }

        for(int i = len - 1;i >= 0;i--){
            Node nNode = nodes[i];
            while(!stack.isEmpty() && (int)stack.peek().value < (int)nNode.value ){
                popStackSetMap(stack,RMaxMap);
            }
            stack.push(nNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack,RMaxMap);
        }

        for(int i = 0;i < len;i++){
            Node curNode = nodes[i];
            Node LBNode = LMaxMap.get(curNode);
            Node RBNode = RMaxMap.get(curNode);
            //以下过程在找当前节点的父节点是谁
            // 如果当前节点
            if(LBNode == null && RBNode == null){
                head = curNode;
            }else if(LBNode == null){
                if(RBNode.left == null){
                    RBNode.left = curNode;
                }else {
                    RBNode.right = curNode;
                }
            }else if(RBNode == null){
                if (LBNode.left == null){
                    LBNode.left = curNode;
                }else {
                    LBNode.right = curNode;
                }
            }else {
                Node parent = (int)RBNode.value > (int)LBNode.value ? LBNode : RBNode;
                if(parent.left == null){
                    parent.left = curNode;
                }else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    public static void popStackSetMap(Stack<Node> stack,Map<Node,Node> tarMap){
        //将栈首node弹出
        Node node = stack.pop();
        if(stack.isEmpty()){
            //如果取出之后栈空了说明当前节点左侧没有比它大的
            tarMap.put(node,null);
        }else {
            //如果不为空那么当前栈首元素（按照现在规则）肯定是左侧（右侧）第一个比它大的节点
            tarMap.put(node,stack.peek());
        }

    }

    public static void main(String[] args) {
        int [] arr = {6,5,4,3,8};
        Node node = getMaxTree(arr);
        System.out.println(node);
    }
}
