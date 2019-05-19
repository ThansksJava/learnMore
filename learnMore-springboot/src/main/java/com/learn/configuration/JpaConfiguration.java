package com.learn.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//@Configuration
public class JpaConfiguration {
//    @Bean
//    public LocalContainerEntityManagerFactoryBean  entityManagerFactory(){
//        LocalContainerEntityManagerFactoryBean em = new
//                LocalContainerEntityManagerFactoryBean();
//        em.
//        return null;
//    }
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
