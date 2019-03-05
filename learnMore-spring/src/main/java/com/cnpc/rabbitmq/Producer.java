package com.cnpc.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/3/2 17:45
 */
public class Producer {
    private static final String HOSTNAME="47.94.83.109";
    private static final Integer PORT=5672;
    private static final String USERNAME="fengjie";
    private static final String PASSWORD="fengjie";
    private static final String EXCHANGE="sendHelloWorld";
    private static final String QUEUE="helloWorld";
    private static final String ROUTTINGKEY="sayHello";
    public static void main(String[] args) {
        try {
            //创建工厂
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(HOSTNAME);
            factory.setPort(PORT);
            factory.setUsername(USERNAME);
            factory.setPassword(PASSWORD);
            //建立连接
            Connection connection = factory.newConnection();
            //创建信道，多个线程可以使用不同的信道而不是建立各自的连接，可以减少性能开销
            Channel channel = connection.createChannel();
            /*
             * @param exchange 交换器名称
             * @param type 交换器类型
             * @param durable 持久化
             * @param autoDelete 当交换器有过绑定的QUENE之后，所有的QUEUE取消跟此交换器的绑定之后自动删除
             * @param internal 是否内置交换器，内置的交换器不能直接接受消息，只能通过其他交换器将消息路由到此交换器 todo
             * @param arguments 结构化参数 todo
             */
            channel.exchangeDeclare(EXCHANGE,"direct",true,false,false,null);
            /*
             * @param queue 消息队列名称
             * @param durable 持久化
             * @param exclusive 排他队列，仅对首次声明它的连接可见，断开则自动删除（即使持久化为true），多个连接不能同时创建同名的排他列 todo
             * @param autoDelete 有消费者连接之后，所有消费者断开连接就会自动删除此队列
             * @param arguments 其他参数 todo
             */
            channel.queueDeclare(QUEUE,true,false,false,null);
            /*
             * @param queue 队列名称
             * @param exchange 交换器名称
             * @param routingKey 路由键，生产者向交换器发消息时指定
             * @param arguments other properties (binding parameters) todo
             */
            channel.queueBind(QUEUE,EXCHANGE,ROUTTINGKEY);
            /*
             * 将信道设置为发送方确认模式
             */
            channel.confirmSelect();
            for(int i = 0;i <= 1000;i++){
                if(i % 2 == 0){
                    channel.basicPublish(EXCHANGE,ROUTTINGKEY, MessageProperties.PERSISTENT_TEXT_PLAIN,(i+" say hi").getBytes());
                }else {
                    channel.basicPublish(EXCHANGE,ROUTTINGKEY, MessageProperties.PERSISTENT_TEXT_PLAIN,(i+" 说你好").getBytes());
                }
                try {
                    System.out.println(channel.waitForConfirms());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
