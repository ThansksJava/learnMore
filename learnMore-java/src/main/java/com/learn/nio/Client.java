package com.learn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/7/9
 */
public class Client implements Runnable{
    private SocketChannel socketChannel;
    private Selector selector;
    private boolean connected;
    private Scanner scanner = new Scanner(System.in);
    String ip;
    int port;
    public Client(String ip,int port) throws IOException {
        this.ip = ip;
        this.port = port;
        selector = Selector.open();
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        connected = true;
        new Thread(this).start();
    }

    private void sendMsg() throws IOException {
        while(true){
            String input = scanner.next();
            doWrite(input);
        }
    }

    private void doWrite(String input) throws IOException {
        byte[] bytes = input.getBytes();
        //根据数组容量创建ByteBuffer
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        //将字节数组复制到缓冲区
        writeBuffer.put(bytes);
        //flip操作
        writeBuffer.flip();
        //发送缓冲区的字节数组
        /*关心事件和读写网络并不冲突*/
        socketChannel.write(writeBuffer);
    }

    private void connect(String ip,int port) throws IOException {
        SocketAddress address = new InetSocketAddress(ip,port);
        if (socketChannel.connect(address)){
            System.out.println("connected to server");
            socketChannel.register(selector, SelectionKey.OP_READ);
        }else {
            System.out.println("注册了一个connect事件");
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    @Override
    public void run() {
        try {
            connect(ip,port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (connected){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    handle(next);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void handle(SelectionKey key) throws IOException {
        if (key.isValid()){
            SocketChannel channel = (SocketChannel)key.channel();
            if (key.isConnectable()) {
                if (channel.finishConnect()){
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else {
                    System.exit(1);
                }
            }
            if(key.isReadable()){
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int readBytes = channel.read(buffer);
                if(readBytes>0){
                    //将缓冲区当前的limit设置为position,position=0，
                    // 用于后续对缓冲区的读取操作
                    buffer.flip();
                    //根据缓冲区可读字节数创建字节数组
                    byte[] bytes = new byte[buffer.remaining()];
                    //将缓冲区可读字节数组复制到新建的数组中
                    buffer.get(bytes);
                    String result = new String(bytes,"UTF-8");
                    System.out.println("客户端收到消息：" + result);
                }
                //链路已经关闭，释放资源
                else if(readBytes<0){
                    key.cancel();
                    channel.close();
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        Client c = new Client("127.0.0.1",1238);
        c.sendMsg();
    }
}
