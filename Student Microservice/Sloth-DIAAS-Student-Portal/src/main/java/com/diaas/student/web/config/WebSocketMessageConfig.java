package com.diaas.student.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration 
@EnableWebSocketMessageBroker
public class WebSocketMessageConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(final StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/chat-example").withSockJS();
	}

	@Override
	public void configureMessageBroker(final MessageBrokerRegistry registry) {
		// TODO Auto-generated method stub
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic");
	}
	
}
