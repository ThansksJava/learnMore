package com.learn.test;

import java.io.IOException;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/1
 */
public class RuntimeTest {
    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
