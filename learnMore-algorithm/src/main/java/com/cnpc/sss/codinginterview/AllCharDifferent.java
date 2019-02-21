package com.cnpc.sss.codinginterview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/2/21 10:41
 */
public class AllCharDifferent {
    public static void main(String[] args) {
        Set<Character> charSet = new HashSet<>();
        char []  c = new char[]{'1','2','3','2'};
        for(char c1 : c){
            charSet.add(c1);
        }
        System.out.println(charSet.size());
    }
}
