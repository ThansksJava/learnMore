package com.learn.io;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/11/26
 * @Time 10:48
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        try {
            StringBuilder sql = new StringBuilder();
            FileInputStream inputStream = new FileInputStream(new File("D:/学习.txt"));
            byte [] bytes = new byte[1024];
            while(inputStream.read(bytes)>0){
//                sql.append(bytes);
                sql.append(new String(bytes));
            }
            System.out.println(sql.toString());
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
