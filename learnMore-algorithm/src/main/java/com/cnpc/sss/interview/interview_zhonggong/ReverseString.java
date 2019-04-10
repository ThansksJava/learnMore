package com.cnpc.sss.interview.interview_zhonggong;

import java.util.Stack;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/8 9:28
 */
public class ReverseString {
    private static final String BLANK=" ";

    /*
     * 字符串中、逆转所有的单词
     * 如："Hello world !"输出之后为："! world Hello"
     * */

    String result = "";

    private String reverse(String str) {

        int lt = str.length() - 1;
        String str_2 = "";
        while (lt >= 0) {
            //注意if嵌套的条件
            if (str.charAt(lt) != ' ' && lt != 0) {
                str_2 = str_2 + str.charAt(lt);
            }
            //用于拼接第一个字符
            else if (lt == 0) {
                str_2 = str_2 + str.charAt(0);
                worldPrint(str_2);
            } else {
                worldPrint(str_2);
                worldPrint(" ");
                str_2 = "";
            }
            lt--;
        }
        return result;
    }

    /**
     *
     * @param str
     */
    public void worldPrint(String str) {
        Stack<Character> stack = new Stack<>();

        if (BLANK.equals(str) || str.length() == 0) {
            result = result + " ";
        } else {
            for (int i = 0; i < str.length(); i++) {
                stack.push(str.charAt(i));
            }
            while (stack.size() > 0) {
                result = result + stack.pop();
            }
            stack.clear();

        }
    }

    /**
     * 逆序输出一句英语
     * 按空格分词放入栈中,再输出来
     * @param str 待逆序英语
     */
    private void reverseWorld(String str){
        Stack<String> stringStack = new Stack<>();
        str = str.trim();
        str+=" ";
        int blankIndex = str.indexOf(" ");
        while(blankIndex != -1){
            int startIndex = 0;
            String singleWord = str.substring(startIndex,blankIndex);
            stringStack.push(singleWord);
            str = str.substring(blankIndex+1);
            blankIndex = str.indexOf(" ");
        }
        while (!stringStack.isEmpty()){
            System.out.print(stringStack.pop());
            System.out.print(" ");
        }
    }
    public static void main(String[] args) {
        ReverseString sr = new ReverseString();
        String str = "How are you !";
        System.out.println(sr.reverse(str));
        sr.reverseWorld(str);
    }
}
