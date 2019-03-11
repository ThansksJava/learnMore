package com.cnpc.io.netty.chapter2demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/11/29 16:52
 */
@ChannelHandler.Sharable
public class EchoServerHandler  extends ChannelInboundHandlerAdapter {
    private ByteBuf byteBuf = null;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"连入");
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class)
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        System.out.println("成功连接第三方服务器。。。");
                    }

                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg1) throws Exception {
                        System.out.println("接收到第三方服务器消息。。。");
                        System.out.println(msg1.toString(CharsetUtil.UTF_8));
                        byteBuf = msg1;
                    }
                });
        bootstrap.group(ctx.channel().eventLoop());
        ChannelFuture connectfuture = bootstrap.connect(new InetSocketAddress("localhost",8089));
        connectfuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                ctx.write(byteBuf);
            }
        });
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf)msg;
        System.out.println("Server received:"+in.toString(CharsetUtil.UTF_8));
//        ctx.write(byteBuf);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        //将未决消息冲刷到远程节点，并且关闭该 Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
