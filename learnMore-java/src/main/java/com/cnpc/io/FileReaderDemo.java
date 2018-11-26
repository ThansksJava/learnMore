package com.cnpc.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/11/26
 * @Time 10:48
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        try {
            StringBuffer str = new StringBuffer();
            char[] buf = new char[1024];
            FileReader f = new FileReader("D:/学习.txt");
            while(f.read(buf)>0){
                str.append(buf);
            }
            System.out.println(str.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
