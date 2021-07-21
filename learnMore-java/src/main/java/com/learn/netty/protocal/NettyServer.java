package com.learn.netty.protocal;

import com.learn.netty.protocal.server.ServerInit;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/7/21
 */
@Slf4j
public class NettyServer {
    public void bind(){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroups = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workGroups)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .childHandler(new ServerInit());
    }

    public static void main(String[] args) {
        new NettyServer().bind();
    }
}
