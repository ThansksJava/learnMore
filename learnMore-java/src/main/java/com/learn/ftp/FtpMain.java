package com.learn.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/4/1
 */
public class FtpMain {
    public static void main(String[] args) throws Exception{
        FTPClient ftpClient = FtpConfig.ftpClient("192.168.253.144",21,"ftpuser","ftp");
        FTPFile [] files = ftpClient.listFiles();
        for (FTPFile file : files) {
            System.out.println(file.getName());
            Date date = file.getTimestamp().getTime();
            SimpleDateFormat f = new SimpleDateFormat("yyyy 年 MM 月 dd 日 E HH 点 mm 分 ss 秒");
            System.out.println(f.format(date));
        }
    }
}
