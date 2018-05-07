package com.cnpc.sss.configuration;

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

@Configuration
@EnableJpaRepositories(value = "com.cnpc.sss.dao",entityManagerFactoryRef="entityManagerFactory")
public class JpaConfiguration {
    @Autowired
    JpaProperties jpaProperties;
    @Bean
    EntityManagerFactory entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(this.dataSource());
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPackagesToScan("com.cnpc.sss.domain");
        factoryBean.setJpaPropertyMap(jpaProperties.getProperties());
        factoryBean.afterPropertiesSet();//在完成了其它所有相关的配置加载以及属性设置后,才初始化
        return factoryBean.getObject();
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
