package com.ms.email.adapters.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class RabbitMQConfig {

	@Value("ms.email")
	private String queue;
	
	@Value("amqps://kseroxjg:dIeKl3E7LYkmcanWXsu9TPbnRmqIvFVE@beaver.rmq.cloudamqp.com/kseroxjg")
	private String uri;
	
	@Bean
	public ConnectionFactory rabbitConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setUri(uri);
		return connectionFactory.getRabbitConnectionFactory();
	}
	
	@Bean
	public Queue queue() {
		return new Queue(queue, true);
	}
	
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
