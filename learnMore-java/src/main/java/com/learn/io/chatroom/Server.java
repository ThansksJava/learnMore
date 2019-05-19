package com.learn.io.chatroom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  <pre>
 *     description:
 *  * 功能1： 客户端通过Java NIO连接到服务端，支持多客户端的连接
 *  * 功能2：客户端初次连接时，服务端提示输入昵称，如果昵称已经有人使用，提示重新输入，如果昵称唯一，则登录成功，
 *          之后发送消息都需要按照规定格式带着昵称发送消息
 *  * 功能3：客户端登录后，发送已经设置好的欢迎信息和在线人数给客户端，并且通知其他客户端该客户端上线
 *  * 功能4：服务器收到已登录客户端输入内容，转发至其他登录客户端。
 *  </pre>
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/11/29 9:34
 */
public class Server {
    private Selector selector = null;
    private static final int PORT = 9999;
    private Charset charset = Charset.forName("UTF-8");
    private static HashSet<String> users = new HashSet<>();
    private static final String USER_ESXIT="系统通知：用户名已存在，请换一个！";
    private static String USER_CONTENT_SPILIT = "#@#";
    private static boolean flag = false;
    private void init() throws IOException {
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        System.out.println("Server is start now....");
        while(true){
            if(selector.select()==0){
                System.out.println("waiting connection....");
                continue;
            }
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keys = selectedKeys.iterator();
            while(keys.hasNext()){
                SelectionKey key = keys.next();
                keys.remove();
                dealWithSelectionKey(serverSocketChannel,key);
            }
        }
    }
    private void dealWithSelectionKey(ServerSocketChannel serverSocketChannel,SelectionKey selectionKey) throws IOException {
        if(selectionKey.isAcceptable()){
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector,SelectionKey.OP_READ);
            //将此对应的channel设置为准备接受其他客户端请求
            selectionKey.interestOps(SelectionKey.OP_ACCEPT);
            System.out.println("Server is listening from client:"+socketChannel.getRemoteAddress());
            socketChannel.write(charset.encode("Please input your name:"));
        }
        if(selectionKey.isReadable()){
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            StringBuilder message = new StringBuilder();
            try{
                while(socketChannel.read(buffer) > 0){
                    buffer.flip();
                    message.append(charset.decode(buffer));
                }
                System.out.println(socketChannel.getRemoteAddress()+"data rev is:"+message);
            }catch (IOException io){
                selectionKey.cancel();
                SocketChannel k = null;
                if(( k = (SocketChannel)selectionKey.channel())!=null){
                    k.close();
                }
            }
            if (message.length() > 0){
                String [] arrayMessage = message.toString().split(USER_CONTENT_SPILIT);
                //注册用户
                if(arrayMessage.length == 1){
                    String name = arrayMessage[0];
                    if(users.contains(name)){
                        socketChannel.write(charset.encode(USER_ESXIT));
                    }else {
                        users.add(name);
                        int onlineNum = onlineNum(selector);
                        String welcome  = "Welcome "+name+" to 1024 chat room!Online numbers:"+onlineNum;
                        broadCast(selector,null,welcome);
                    }
                }
                //注册完成后，发送消息
                else if(arrayMessage.length > 1){
                    String name = arrayMessage[0];
                    String sendMessage = message.substring(name.length()+USER_CONTENT_SPILIT.length());
                    sendMessage = name + " say " + sendMessage;
                    if(users.contains(name)) {
                        //不回发给发送此内容的客户端
                        broadCast(selector, socketChannel, sendMessage);
                    }
                }
            }
        }
    }
    private static int onlineNum(Selector selector){
        return 0;
    }
    private void broadCast(Selector selector,SocketChannel exceptSocketChannel,String sendMessage) throws IOException {
        for(SelectionKey key : selector.keys()){
            Channel targetChannel = key.channel();
            if(targetChannel instanceof SocketChannel && targetChannel != exceptSocketChannel){
                SocketChannel targetSocketChannel = (SocketChannel)targetChannel;
                targetSocketChannel.write(charset.encode(sendMessage));
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Server().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
