package com.rabbitmq.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
	
	public static final String QUEUE = "rabbitmq-queue";
	public static final String EXCHANGE = "rabbitmq-exchange";
	public static final String ROUTING_KEY = "rabbitmq-routing-key";

	
	
	 	@Bean
	    public Queue queue() { //hold message, consumer will consume messages/events from queue
	        return new Queue(QUEUE);
	    }

	    @Bean
	    public TopicExchange exchange() { // interemediate between producer and queue
	        return new TopicExchange(EXCHANGE);
	    }

	    @Bean
	    public Binding binding(Queue queue, TopicExchange exchange) { //bind corresponding queue to exchange using routing key
	        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	    }

	    @Bean
	    public MessageConverter converter() { //
	        return new Jackson2JsonMessageConverter();
	    }

	    @Bean
	    public AmqpTemplate template(ConnectionFactory connectionFactory) { //allow producer to publish event and consumer to consume event
	        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(converter());
	        return rabbitTemplate;
	    }

}
