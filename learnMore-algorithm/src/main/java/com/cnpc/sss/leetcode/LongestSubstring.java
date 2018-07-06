package com.cnpc.sss.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/6
 * @Time 11:32
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char [] str = s.toCharArray();
        Map<Character,Object> map = new HashMap<>();
        int largest = 0;
        int length = str.length;
        if (str.length == 1){
            largest = 1;
            return largest;
        }
        for (int i = 0;i < length;i++){
            for(int j = i;j < length;j++){
                if(map.containsKey(str[j])){
                    int curentSize = map.size();
                    largest = largest > curentSize?largest:curentSize;
                    map = new HashMap<>();break;
                }else {
                    map.put(str[j],"");
                }
            }
        }
        return largest;
    }
    public static int lengthOfLongestSubstringLee(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "jbpnbwwd";
        System.out.println(str+"的最大子串长度是："+lengthOfLongestSubstring(str));
    }
}
