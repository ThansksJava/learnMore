package com.cnpc.dao.impl;

import com.cnpc.dao.DataDao;
import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/9/1
 * @Time 11:48
 */
@Repository
public class DataDaoImpl implements DataDao {
    @Autowired
    private InfluxDB influxDB;
    @Override
    public void addCpu() {

    }
}
