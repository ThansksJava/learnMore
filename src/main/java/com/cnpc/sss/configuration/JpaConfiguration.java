package com.cnpc.sss.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.cnpc.sss.dao")
public class JpaConfiguration {
    @Bean
    EntityManagerFactory entityManagerFactory(){
        return null;
    }
    /**
     * ConfigurationProperties(prefix = "spring.datasource")
     * 自动对DruidDataSource中的属性进行配置
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}
