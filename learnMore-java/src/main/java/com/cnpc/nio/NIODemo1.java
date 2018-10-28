package com.cnpc.nio;

import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/8/21
 * @Time 16:23
 */
public class NIODemo1 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile raf = new RandomAccessFile("D:/NIOTEST.txt","rw");
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE,0,raf.length());
        while(mbb.hasRemaining()){
            System.out.println((char)mbb.get());
        }
//        mbb.put(0,(byte)98);
        raf.close();
    }
}
