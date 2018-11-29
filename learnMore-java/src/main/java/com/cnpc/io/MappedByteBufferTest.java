package com.cnpc.io;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author fengjie
 * @date Created in 2018/11/28
 */
public class MappedByteBufferTest {
    @Test
    public void test() throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:/test.txt","rw");
        FileChannel channel = file.getChannel();
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE,0,file.length());
        channel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print((char)buffer.get());
        }

    }
}
