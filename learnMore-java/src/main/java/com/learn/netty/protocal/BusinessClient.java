package com.learn.netty.protocal;

import com.learn.netty.NettyClient;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/7/21
 */
@Slf4j(topic = "e")
public class BusinessClient {

    public static void main(String[] args) throws InterruptedException {
        NettyClient nettyClient = new NettyClient();
        new Thread(nettyClient).start();
        while (!nettyClient.isConnected()){
            /*主线程wait,放弃锁等待连接成功后被唤醒*/
            synchronized (nettyClient){
                log.info("还没有连接完毕，在等待中...");
                nettyClient.wait();
            }
        }
    }
}
