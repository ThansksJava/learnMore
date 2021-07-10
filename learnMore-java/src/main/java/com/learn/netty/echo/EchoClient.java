package com.learn.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/7/10
 */
@Slf4j(topic = "enjoy")
public class EchoClient {
    private int port;
    private String host;

    public EchoClient(int port,String host) {
        this.port = port;
        this.host = host;

    }
    public void startClient() throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    /*指定使用NIO的方式*/
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host,port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new SimpleChannelInboundHandler<ByteBuf>() {
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                                    log.info("客户端收到服务器回传消息："+msg.toString(StandardCharsets.UTF_8));
                                }

                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    ctx.writeAndFlush(Unpooled.copiedBuffer("Hello Netty",StandardCharsets.UTF_8));
                                }
                            });
                        }
                    });
            /*创建一个channel到对端，sync会阻塞到完成*/
            ChannelFuture channelFuture = bootstrap.connect().sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully().sync();
        }

    }
    public static void main(String[] args) throws InterruptedException {
        EchoClient server = new EchoClient(1234,"127.0.0.1");
        server.startClient();
    }
}
