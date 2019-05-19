package com.learn.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/8/14
 * @Time 15:37
 */
//@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpoint(){
        return new ServerEndpointExporter();
    }
}
