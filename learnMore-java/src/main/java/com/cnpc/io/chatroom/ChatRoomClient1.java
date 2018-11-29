package com.cnpc.io.chatroom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/11/29 10:52
 */
public class ChatRoomClient1 {
    private Selector selector = null;
    private final int PORT=9999;
    private Charset charset = Charset.forName("UTF-8");
    private SocketChannel socketChannel = null;
    private String name ="";
    private static final String USER_EXIST="系统通知：用户名已存在，请换一个！";
    private static final String USER_CONTENT_SPILIT = "#@#";
    public void init() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        ExecutorService thread = Executors.newCachedThreadPool();
        thread.submit(new ClientThread());

        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if("".equals(line)){
                System.out.println("消息不能为空!");
                continue;
            }
            if("".equals(name)){
                name = line;
                line = name+USER_CONTENT_SPILIT;
            }else{
                line = name+USER_CONTENT_SPILIT+line;
            }
            socketChannel.write(charset.encode(line));
        }


    }
    private class ClientThread implements Runnable{
        @Override
        public void run() {
            try{
                while(true){
                    if( selector.select() == 0) {
                        continue;
                    }
                    Set<SelectionKey> selectedKey = selector.selectedKeys();
                    Iterator<SelectionKey> keys = selectedKey.iterator();
                    while(keys.hasNext()){
                        SelectionKey selectionKey = keys.next();
                        keys.remove();
                        dealWithSelectionKey(selectionKey);
                    }
                }
            }catch (IOException e){

            }
        }
    }
    private void dealWithSelectionKey(SelectionKey selectionKey) throws IOException {
        if(selectionKey.isReadable()){
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String message = "";
            while(socketChannel.read(buffer) > 0){
                buffer.flip();
                message += charset.decode(buffer);
            }
            if(USER_EXIST.equals(message)){
                name = "";
            }
            System.out.println(message);
            selectionKey.interestOps(SelectionKey.OP_READ);
        }
    }

    public static void main(String[] args) {
        try {
            new ChatRoomClient1().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
