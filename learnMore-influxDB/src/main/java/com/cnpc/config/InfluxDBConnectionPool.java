package com.cnpc.config;

import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/9/3
 * @Time 9:41
 */
@Slf4j
public class InfluxDBConnectionPool {
    private String url;
    private String username;
    private String password;

    /**
     * 连接池的初始大小
     */
    private int initialConnections = 10;
    /**
     * 连接池自动增加的大小
     */
    private int incrementalConnections = 5;
    /**
     *连接池最大的大小
     */
    private int maxConnections = 50;
    /**
     *
     * 存放连接池中数据库连接的向量,初始时为null
     * */
    private Vector connections = null;

    public InfluxDBConnectionPool(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * 返回连接池的初始大小
     *
     * @return 初始连接池中可获得的连接数量
     */
    public int getInitialConnections() {
        return this.initialConnections;
    }

    /**
     * 设置连接池的初始大小
     *
     * @param initialConnections 用于设置初始连接池中连接的数量
     */
    public void setInitialConnections(int initialConnections) {
        this.initialConnections = initialConnections;
    }

    /**
     * 返回连接池自动增加的大小 、
     *
     * @return 连接池自动增加的大小
     */
    public int getIncrementalConnections() {
        return this.incrementalConnections;
    }

    /**
     * 设置连接池自动增加的大小
     *
     * @param incrementalConnections 连接池自动增加的大小
     */

    public void setIncrementalConnections(int incrementalConnections) {
        this.incrementalConnections = incrementalConnections;
    }

    /**
     * 返回连接池中最大的可用连接数量
     *
     * @return 连接池中最大的可用连接数量
     */
    public int getMaxConnections() {
        return this.maxConnections;
    }

    /**
     * 设置连接池中最大可用的连接数量
     *
     * @param maxConnections 设置连接池中最大可用的连接数量值
     */
    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public synchronized void createInfluxDBConnectionPool() throws Exception {
        if (connections != null) {
            return;
        }
        connections = new Vector();
        //建立initialConnections数量大小的连接放入连接池中
        createInfluxDBConnections(this.initialConnections);
        log.info("创建连接池成功");
    }


    /**
     * 创建由 numConnections 指定数目的数据库连接 , 并把这些连接 放入 connections 向量中
     *
     * @param numConnections 要创建的数据库连接的数目
     */
    private void createInfluxDBConnections(int numConnections) throws Exception {
        // 循环创建指定数目的数据库连接
        for (int x = 0; x < numConnections; x++) {
            // 是否连接池中的数据库连接的数量己经达到最大？最大值由类成员 maxConnections
            // 指出，如果 maxConnections 为 0 或负数，表示连接数量没有限制。
            // 如果连接数己经达到最大，即退出。
            if (this.maxConnections > 0
                    && this.connections.size() >= this.maxConnections) {
                break;
            }
            // 增加一个连接到连接池中（向量 connections 中）
            try {
                InfluxDB influxDB = InfluxDBFactory.connect(url, username, password);
                //TODO 2018年9月3日10:34:45 需要验证是否通畅吗
                connections.addElement(influxDB);
            } catch (Exception e) {
                System.out.println(" 创建数据库连接失败！ " + e.getMessage());
                throw new Exception();
            }
            // System.out.println(" 数据库连接己创建 ......");
        }
    }
    /**
     * 创建一个新的数据库连接并返回它
     * @return 返回一个新创建的数据库连接
     */
    private InfluxDB newConnection() throws Exception {
        // 创建一个数据库连接
        InfluxDB influxDB = InfluxDBFactory.connect(url,username,password);
        // 返回创建的新的数据库连接
        return influxDB;
    }
    /**
     * 通过调用 getFreeConnection() 函数返回一个可用的数据库连接,如果当前没有可用的数据库连接，并且更多的数据库连接不能创
     * 建（如连接池大小的限制），此函数等待一会再尝试获取。
     * @return 返回一个可用的数据库连接对象
     */
    public synchronized InfluxDB getConnection() throws Exception {
        // 确保连接池己被创建
        if (connections == null) {
            // 连接池还没创建，则返回 null
            return null;
        }
//        // 获得一个可用的数据库连接
//        InfluxDB conn = getFreeConnection();
//        // 如果目前没有可以使用的连接，即所有的连接都在使用中
//        while (conn == null) {
//            // 等一会再试
//            wait(250);
//            // 重新再试，直到获得可用的连接，如果
//            // getFreeConnection() 返回的为 null
//            // 则表明创建一批连接后也不可获得可用连接
//            conn = getFreeConnection();
//        }
        // 返回获得的可用的连接
        return null;
    }

}
