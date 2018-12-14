package com.cnpc.io.netty.chapter2demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * <p>
 * 绑定到服务器将在其上监听并接受传入连接请求的端口；
 * 配置 Channel，以将有关的入站消息通知给 EchoServerHandler实例
 * </p>
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/11/30 9:28
 */
public class ThirdEchoServer {
    private final int port;

    public ThirdEchoServer(int port) {
        this.port = port;
    }
    public void start() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                ctx.channel().writeAndFlush(Unpooled.copiedBuffer("woshimi", CharsetUtil.UTF_8));
                            }
                        });
                    }
                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        System.out.println(ctx.channel().remoteAddress()+"连入");
                    }
                });
        ChannelFuture f = bootstrap.bind().sync();
        System.out.println(ThirdEchoServer.class.getName() +
                " started and listening for connections on " + f.channel().localAddress());
        f.channel().closeFuture().sync();
        group.shutdownGracefully().sync();
    }
    public static void main(String[] args) {
        try {
            new ThirdEchoServer(8089).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
