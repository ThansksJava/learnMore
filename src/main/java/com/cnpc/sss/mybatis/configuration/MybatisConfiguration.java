package com.cnpc.sss.mybatis.configuration;

import com.github.pagehelper.PageInterceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/17
 * @Time 10:07
 */

@Configuration
public class MybatisConfiguration {
    private static Log logger = LogFactory.getLog(MybatisConfiguration.class);

    @Autowired
    private DataSource dataSource;

    // 提供SqlSeesion
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource);
            // 手写配置
            // 配置类型别名
//            sessionFactoryBean.setTypeAliasesPackage("com.zsx.entity");

            // 配置mapper的扫描，找到所有的mapper.xml映射文件
//            Resource[] resources = new PathMatchingResourcePatternResolver()
//                    .getResources("classpath:mapping/*.xml");
//            sessionFactoryBean.setMapperLocations(resources);

            // 加载全局的配置文件
//            sessionFactoryBean.setConfigLocation(
//                    new DefaultResourceLoader().getResource("classpath:mybatis/mybatis-config.xml"));

            /*添加插件*/
            sessionFactoryBean.setPlugins(new Interceptor[]{initPageInterceptor()});

            return sessionFactoryBean.getObject();
        } catch (IOException e) {
            logger.warn("mybatis resolver mapper*xml is error");
            return null;
        } catch (Exception e) {
            logger.warn("mybatis sqlSessionFactoryBean create error");
            return null;
        }
    }
    @Bean
    public PageInterceptor initPageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
