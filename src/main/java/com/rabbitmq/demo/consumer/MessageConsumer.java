package com.rabbitmq.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.demo.config.MessagingConfig;

@Component
public class MessageConsumer {
	
	private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessage() {
		logger.info("message received from queue : " +MessagingConfig.QUEUE);
		
		
	}

}
