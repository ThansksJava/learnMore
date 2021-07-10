package com.learn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/7/9
 */
public class Server implements Runnable{
    private boolean started;
    private ServerSocketChannel server;
    private Selector selector;
    public Server(int port) throws IOException {
        selector = Selector.open();
        server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(port),1024);
        server.register(selector, SelectionKey.OP_ACCEPT);
        started=true;
        System.out.println("服务端启动 端口号：" + port);
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(started){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                while (selectionKeyIterator.hasNext()){
                    SelectionKey key = selectionKeyIterator.next();
                    selectionKeyIterator.remove();
                    try {
                        handle(key);
                    } catch (IOException e) {
                        if (key != null){
                             key.cancel();
                             if (key.channel() != null){
                                 key.channel().close();
                             }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handle(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()){
            if (selectionKey.isAcceptable()){
                ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                SocketChannel socketChannel = channel.accept();
                System.out.println("建立新的连接");
                socketChannel.configureBlocking(false);
                socketChannel.register(selector,SelectionKey.OP_READ);
            }
            if (selectionKey.isReadable()){
                SocketChannel sc = (SocketChannel) selectionKey.channel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int readByte = sc.read(buffer);
                if(readByte > 0){
                    buffer.flip();
                    byte [] msg = new byte[buffer.remaining()];
                    buffer.get(msg);
                    String message = new String(msg, StandardCharsets.UTF_8);
                    System.out.println(message);

                    response(sc,message);
                }else{
                    sc.close();
                    selectionKey.cancel();
                }
            }
        }
    }

    private void response(SocketChannel sc, String message) throws IOException {
        message = "服务器在"+LocalDateTime.now()+" 收到消息："+message;
        ByteBuffer respbuff = ByteBuffer.allocate(message.getBytes(StandardCharsets.UTF_8).length);
        respbuff.put(message.getBytes(StandardCharsets.UTF_8));
        respbuff.flip();
        sc.write(respbuff);
    }

    public static void main(String[] args) throws IOException {
        new Server(1238);
    }
}
