package com.learn.netty;

import com.learn.netty.protocal.client.ClientInit;
import com.learn.netty.protocal.vo.Header;
import com.learn.netty.protocal.vo.Message;
import com.learn.netty.protocal.vo.MessageType;
import com.learn.netty.protocal.vo.NettyConstant;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/7/21
 */
@Slf4j(topic = "e")
public class NettyClient implements Runnable{
    /*负责重连的线程池*/
    private ScheduledExecutorService executor = Executors
            .newScheduledThreadPool(1);
    /*是否用户主动关闭连接的标志值*/
    private volatile boolean userClose = false;
    /**
     * channel要拿来发送消息所以要拿出来
     * */
    private Channel channel;
    /*连接是否成功关闭的标志值*/
    private volatile boolean connected = false;

    public boolean isConnected() {
        return connected;
    }
    private EventLoopGroup group = new NioEventLoopGroup();

    public void connect(String host,int port) throws InterruptedException {
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientInit());
            ChannelFuture future = bootstrap.connect(new InetSocketAddress(host, port)).sync();
            channel = future.sync().channel();
            synchronized (this){
                this.connected = true;
                this.notifyAll();
            }
            future.channel().closeFuture().sync();
        } finally {
            if(!userClose){
                /*非正常关闭，有可能发生了网络问题，进行重连*/
                log.info("需要进行重连");
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            /*给操作系统足够的时间，去释放相关的资源*/
                            TimeUnit.SECONDS.sleep(1);
                            connect(NettyConstant.SERVER_IP,
                                    NettyConstant.SERVER_PORT);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }else{
                /*正常关闭*/
                channel = null;
                group.shutdownGracefully().sync();
                synchronized (this){
                    this.connected = false;
                    this.notifyAll();
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            connect(NettyConstant.SERVER_IP,
                    NettyConstant.SERVER_PORT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * ------------以下方法供业务方使用--------------------------
     * */
    public void send(Object message) {
        if(channel==null||!channel.isActive()){
            throw new IllegalStateException("和服务器还未未建立起有效连接！" +
                    "请稍后再试！！");
        }
        Message msg = new Message();
        Header myHeader = new Header();
        myHeader.setType(MessageType.SERVICE_REQ.value());
        msg.setHeader(myHeader);
        msg.setBody(message);
        channel.writeAndFlush(msg);
    }

    public void close() {
        userClose = true;
        channel.close();
    }
}
