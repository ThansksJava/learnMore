package com.cnpc.rabbitmq;

import com.rabbitmq.client.*;
import org.omg.CORBA.TIMEOUT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/3/2 17:45
 */
public class Consumer {
    private static final String USERNAME="fengjie";
    private static final String PASSWORD="fengjie";
    private static final String IP_ADDRESS="47.94.83.109";
    private static final Integer PORT=5672;

    public static void main(String[] args) {
        try {
            Address [] addresses = new Address[]{new Address(IP_ADDRESS,PORT)};
            //创建工厂
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUsername(USERNAME);
            factory.setPassword(PASSWORD);
            //建立连接
            Connection connection = factory.newConnection(addresses);
            Channel channel = connection.createChannel();
            //客户端最多接受未被ACK的消息的个数
            channel.basicQos(1);
            DefaultConsumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body)
                        throws IOException
                {
                    System.out.println("revieve message："+new String(body));
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            };
            channel.basicConsume("helloWorld",consumer);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
