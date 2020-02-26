package com.zjhz.gismap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 
 * @author DencyCheng
 *
 */
@Configuration
@EnableWebMvc
@EnableWebSocketMessageBroker //能够在 WebSocket 上启用 STOMP
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
 
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");//订阅地址
        config.setApplicationDestinationPrefixes("/websocket");
    }
 
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //setAllowedOrigins("*") 解决了跨域问题
    	 registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("*").withSockJS();
    }
 
}