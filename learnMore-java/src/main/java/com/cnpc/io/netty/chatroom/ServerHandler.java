package com.cnpc.io.netty.chatroom;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/5 14:30
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 以下四个方法为Channel 的生命周期状态方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel 已经被注册到了 EventLoop");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel 处于活动状态（已经连接到它的远程节点）。它现在可以接收和发送数据了");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel 没有连接到远程节点");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel 已经被创建，但还未注册到 EventLoop");
    }

    /**
     * 以下三个方法 ChannelHandler 的生命周期方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("把 ChannelHandler 添加到 ChannelPipeline 中");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("从 ChannelPipeline 中移除 ChannelHandler" );
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("在 ChannelPipeline 中有错误");

    }




}
