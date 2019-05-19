package com.learn.io;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/11/27
 * @Time 9:43
 */
public class NIOMyDemo {
    public static void  ioMethod() throws Exception{
        RandomAccessFile readFile = new RandomAccessFile("D:/test.txt","rw");
        FileChannel readChannel = readFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(2048);
        int bytesRead = readChannel.read(buf);
        while(bytesRead !=-1){
            System.out.println("read:"+bytesRead);
            buf.flip();
            int i = 0;
            while(buf.hasRemaining()&& i <= 20){
                System.out.print((char)buf.get());
                i++;
            }
            buf.clear();
            bytesRead = readChannel.read(buf);
        }
        readFile.close();
        readChannel.close();
    }
    public static void  ioScaterMethod() throws Exception{
        RandomAccessFile readFile = new RandomAccessFile("D:/test.txt","rw");
        FileChannel readChannel = readFile.getChannel();
        ByteBuffer buf1 = ByteBuffer.allocate(1024);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        ByteBuffer [] bufAll = {buf1,buf2};
        long bytesRead = readChannel.read(bufAll);
        while(bytesRead !=-1L){
            System.out.println("read:"+bytesRead);
            buf1.flip();
            buf2.flip();
            while(buf1.hasRemaining()){
                    System.out.print((char)buf1.get());
            }
            while(buf2.hasRemaining()){
                    System.out.print((char)buf2.get());
            }
            buf1.clear();
            buf2.clear();
            bytesRead = readChannel.read(bufAll);
        }
        readFile.close();
    }
    @Deprecated
    public static void  ioGatherMethod() throws Exception{
        RandomAccessFile readFile = new RandomAccessFile("D:/test.txt","rw");
        FileChannel readChannel = readFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = readChannel.read(buf);
        while(bytesRead !=-1){
            System.out.println("read:"+bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = readChannel.read(buf);
        }
        readFile.close();
        readChannel.close();
    }
    public static void  ioTransforMethod() throws Exception{
        RandomAccessFile readFile = new RandomAccessFile("D:/test.txt","rw");
        FileChannel readChannel = readFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("D:/testNew.txt", "rw");
        FileChannel  toChannel = toFile.getChannel();
        readChannel.transferTo(0,readChannel.size(),toChannel);
        readFile.close();
        toFile.close();
    }

    /**
     * 1、创建Selector
     * 2、向Selector注册通道
     *   2.1 创建Channel
     *   2.2 绑定端口
     *   2.3 设置阻塞与否
     *   2.4 注册，设置对什么连接通道感兴趣，第一次必须是OP_ACCEPT
     *   2.5 注册同时附加对象 可选（与第三步二选一进行设置即可）
     * 3、通过第二步返回值SelectionKey附加对象 可选
     * 4、访问就绪通道
     *   4.1 SocketChannel第一连接一定是 Accept 所以会进入accept分支
     *   4.2 可以在accept中进行读数据、或者像ServerConnect中那样通过SelectionKey得到Selector和Channel，将 SelectionKey.OP_READ
     *       注册进去，下一次循环就进入了read分支
     * @throws Exception
     */
    public static void  ioSelectorMethod() throws Exception{
        ByteBuffer readbuffer = ByteBuffer.allocate(1024);
        //1、创建Selector
        Selector selector = Selector.open();
        //2、向Selector注册通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        SelectionKey key = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        //4、附加对象  or SelectionKey key = channel.register(selector, SelectionKey.OP_READ, theObject)
        key.attach(readbuffer);
        //5、有多少个通道准备就绪
        while(true){
            //3、ready 集合：通道已经准备就绪的操作的集合
            int readySet = key.readyOps();
            System.out.println(readySet);
            if(selector.select(3000) == 0){
                System.out.println("waiting.............");
                continue;
            }
            //6、访问就绪通道
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectedKeys.iterator();
            while(it.hasNext()){
                SelectionKey sk = it.next();
                if(sk.isAcceptable()) {
                    System.out.println("建立连接。。。。。。。。。。。。");
                    ByteBuffer buffer = (ByteBuffer)sk.attachment();
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel)sk.channel();
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    int bufferc = socketChannel.read(buffer);
                    while(bufferc !=-1){
                        buffer.flip();
                        while(buffer.hasRemaining()){
                            System.out.print((char) buffer.get());
                        }
                        buffer.clear();
                        bufferc = socketChannel.read(buffer);
                    }
                }
                if (sk.isConnectable()) {
                    // a connection was established with a remote server.
                }
                if (sk.isReadable()) {
                    // a connection was accepted by a ServerSocketChannel.

                }
                if (sk.isWritable()) {
                    // a channel is ready for writing
                }
                selectedKeys.remove(sk);
            }
        }

    }


    public static void main(String[] args) {
        try {
//            ioMethod();
//            ioScaterMethod();
//            ioGatherMethod();
//            ioTransforMethod();
            ioSelectorMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
