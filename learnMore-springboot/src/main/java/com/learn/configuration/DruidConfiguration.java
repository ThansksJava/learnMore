package com.learn.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/10
 * @Time 14:07
 */
@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean statViewServlet(){
        /*创建servlet注册实体*/
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        /*设置ip白名单*/
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        /*设置ip黑名单如果有的话*/
        servletRegistrationBean.addInitParameter("deny","");
        /*设置控制台管理用户*/
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","admin");
        /*是否可以重置数据*/
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return  servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusion","*.js,*.gif,*.css,*.jpg,*.png,/druid/*");
        return filterRegistrationBean;
    }
}
