package com.learn.io.clientIsNIODemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/11/26
 * @Time 15:23
 */
public class Client2 {
    public static void client() throws Exception{
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try
        {
            //1、打开SocketChannel
            socketChannel = SocketChannel.open();
            //2、设置为非阻塞
            socketChannel.configureBlocking(false);
            //3、建立连接
            socketChannel.connect(new InetSocketAddress("127.0.0.1",8080));

            if(socketChannel.finishConnect())
            {
                int i=0;
                while(true)
                {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "Client2I'm "+i+++"-th information from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while(buffer.hasRemaining()){
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                }
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(socketChannel!=null){
                    socketChannel.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
