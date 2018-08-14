package com.cnpc.sss.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpoint;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/8/14
 * @Time 15:37
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpoint(){
        return new ServerEndpointExporter();
    }
}
