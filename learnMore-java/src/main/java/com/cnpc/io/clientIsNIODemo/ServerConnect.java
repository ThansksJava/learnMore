package com.cnpc.io.clientIsNIODemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class ServerConnect
{
    private static final int BUF_SIZE=1024;
    private static final int PORT = 8080;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args)
    {
        selector();
    }

    private static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ,ByteBuffer.allocateDirect(BUF_SIZE));
    }

    private static void handleRead(SelectionKey key){
        System.out.println("selectionkeyA是否有效？"+key.isValid());
        SocketChannel sc = (SocketChannel)key.channel();
        ByteBuffer buf = (ByteBuffer)key.attachment();
        long bytesRead = 0;
        try {
            bytesRead = sc.read(buf);
            while(bytesRead>0){
                buf.flip();
                while(buf.hasRemaining()){
                    System.out.print((char)buf.get());
                }
                System.out.println();
                buf.clear();
                bytesRead = sc.read(buf);
                if(bytesRead == -1){
                    sc.close();
                }
            }
        } catch (IOException e) {
            System.out.println("一个连接关闭了。。。");
//            key.cancel();
        }
    }

    private static void handleWrite(SelectionKey key) throws IOException{
        ByteBuffer buf = (ByteBuffer)key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        buf.compact();
    }

    private static void selector() {
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;
        try{
            //创建Selector
            selector = Selector.open();
            serverSocketChannel= ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            //与Selector一起使用时，Channel必须处于非阻塞模式下
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            int outWhileCycleCount = 0;
            while(true){
                System.out.println("外层while："+(++outWhileCycleCount));
                if(selector.select(TIMEOUT) == 0){
                    System.out.println("==");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while(iter.hasNext()){
                    SelectionKey key = iter.next();
                    System.out.println("key.ready:"+key.readyOps());
                    if(key.isAcceptable()){
                        handleAccept(key);
                    }
                    else if(key.isReadable()){
                        handleRead(key);
                    }
                    else if(key.isWritable() && key.isValid()){
                        handleWrite(key);
                     }
                    else if(key.isConnectable()){
                        System.out.println("isConnectable = true");
                    }
                    iter.remove();
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(selector!=null){
                    selector.close();
                }
                if(serverSocketChannel!=null){
                    serverSocketChannel.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}