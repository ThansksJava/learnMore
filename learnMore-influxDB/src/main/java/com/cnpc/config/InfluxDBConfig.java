package com.cnpc.config;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/9/2
 * @Time 18:59
 */
@Configuration
public class InfluxDBConfig {
    @Value("${influxDB.url}")
    private String url;
    @Value("${influxDB.username}")
    private String username;
    @Value("${influxDB.password}")
    private String password;
    @Value("${influxDB.database}")
    private String database;
    @Bean
    public InfluxDB influxDB(){
        InfluxDB influxDB = InfluxDBFactory.connect(url,username,password);
        influxDB.setDatabase(database);
        return influxDB;
    }
}
