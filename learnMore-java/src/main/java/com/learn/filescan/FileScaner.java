package com.learn.filescan;


import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/4/2
 */
public class FileScaner {
    public static void fileScaner(String path) throws IOException {
        File file = new File(path);
        File [] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getName());
            BasicFileAttributes attributes = Files.readAttributes(file1.toPath(), BasicFileAttributes.class);
            Date createDate = new Date(attributes.creationTime().toMillis());
            SimpleDateFormat f = new SimpleDateFormat("yyyy 年 MM 月 dd 日 E HH 点 mm 分 ss 秒");
            System.out.println(f.format(createDate));
            Date modifyDate = new Date(attributes.lastModifiedTime().toMillis());
            System.out.println(f.format(modifyDate));
//            attributes.lastModifiedTime();
//            if (file1.isDirectory()){
//                System.out.println("进入目录"+file1.getPath());
//                fileScaner(file1.getPath());
//            }
        }
    }

    public static void main(String[] args)throws Exception {
        FileScaner.fileScaner("D:\\omseversion");
    }
}
