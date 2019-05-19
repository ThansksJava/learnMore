package com.learn.io;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/11/28
 * @Time 13:50
 */
public class NioPathTest {
    @Test
    public void createAbsolutePath(){
        Path path = Paths.get("D:/nioPathCreate.txt");
        System.out.println(Files.exists(path));
    }
    @Test
    public void createRelativePath(){
        Path path = Paths.get("D:/nioPath","nioPathCreate.txt");
        //result:D:\nioPath\nioPathCreate.txt
        System.out.println(path.toAbsolutePath());
    }
    @Test
    public void asynchronousFileChannelTest() throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:/test.txt");
        AsynchronousFileChannel fileChannel =
                AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Future<Integer> future = fileChannel.read(buffer,0);
        while(true){
            if(future.isDone()){
                buffer.flip();
                byte[] data = new byte[buffer.limit()];
                buffer.get(data);
                System.out.println(new String(data));
                buffer.clear();
                break;
            }else{
                System.out.println(future.get());
            }
        }
    }
    @Test
    public void asynchronousFileChannelTest1() throws IOException{
        Path path = Paths.get("D:/test.txt");
        AsynchronousFileChannel fileChannel =
                AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println(result);
                buffer.flip();
                byte[] data = new byte[buffer.limit()];
                buffer.get(data);
                System.out.println(new String(data));
                buffer.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("读取失败。。。");
            }
        });

        System.out.println(".............");

    }
}
