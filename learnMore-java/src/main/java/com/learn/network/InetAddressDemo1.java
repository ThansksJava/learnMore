package com.learn.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/7/5
 */
public class InetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress byName = InetAddress.getByName("www.bibili.com");
        System.out.println(byName.getHostAddress());

        InetAddress byName1 = InetAddress.getByName("192.168.253.1");
        NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(byName1);
        System.out.println(byInetAddress.getName());
    }
}
