package com.cnpc.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/11/26
 * @Time 14:56
 */
public class NIODemo2 {
    /**
     * IO例子
     */
    public static void IOMethod(){
        InputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream("D:/学习.txt"));

            byte [] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1)
            {
                for(int i=0;i<bytesRead;i++){
                    System.out.print((char)buf[i]);
                }
                bytesRead = in.read(buf);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * NIO例子
     */
    public static void NIOMethod(){
        RandomAccessFile aFile = null;
        RandomAccessFile bFile = null;
        try{
            aFile = new RandomAccessFile("D:/cpu_v2.csv","rw");
            bFile = new RandomAccessFile("D:/cpu_v2.txt","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);

            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);

            while(bytesRead != -1)
            {
                buf.flip();
                while(buf.hasRemaining())
                {
                    char c = (char)buf.get();
                    System.out.print(c);
                    bFile.write(c);
                }
                //将Buffer中的未读数据放入其实位置position设到最后一个未读元素后面
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
            //position位置重新置为0，可以重读
//            buf.rewind();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
                if(bFile != null){
                    bFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void  doOthers(){
        System.out.println("我在做其他的事情。。。。。。");
    }
    public static void main(String[] args) {
//        IOMethod();
        NIOMethod();
        doOthers();
    }
}
