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
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf)msg;
        System.out.println("Server received:"+in.toString(CharsetUtil.UTF_8));
//        final ByteBuf[] thirdMsg = new ByteBuf[1];
        //充当客户端请求第三方
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(ctx.channel().eventLoop());
        bootstrap.channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress("127.0.0.1",8089))
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        System.out.println("成功连接第三方服务器。。。");
                    }

                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg1) throws Exception {
                        System.out.println("接收到第三方服务器消息。。。");
                        System.out.println(msg1.toString(CharsetUtil.UTF_8));
//                        thirdMsg[0] = msg1;
//                        ctx.writeAndFlush(thirdMsg[0]);
                        ctx.writeAndFlush(msg1);
                        System.out.println("发送到客户端完成");
                    }
                });
        ChannelFuture future = bootstrap.connect();
//        future.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) {
//                if (future.isSuccess()) {
//                    try{
//                        System.out.println("即将发送数据："+thirdMsg[0].toString(CharsetUtil.UTF_8));
//                        ctx.write(thirdMsg[0]);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                } else {
//                    System.err.println("Bind attempt failed");
//                    future.cause().printStackTrace();
//                }
//            }
//        });
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

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"连入");
    }
}
