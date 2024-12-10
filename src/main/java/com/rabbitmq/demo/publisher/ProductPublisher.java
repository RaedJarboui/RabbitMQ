package com.rabbitmq.demo.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.demo.config.MessagingConfig;
import com.rabbitmq.demo.dto.ProductRequest;
import com.rabbitmq.demo.dto.ProductResponse;

@RestController
@RequestMapping("/products")
public class ProductPublisher {
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/save")
	private String publishProductToQueue(@RequestBody ProductRequest product) {
		product.setId(UUID.randomUUID().toString());
		ProductResponse response = new ProductResponse(product,"product sent successfully");
		template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY, product);
		return "product published successfully";
		
		
	}
	

}
