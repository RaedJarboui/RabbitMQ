package com.rabbitmq.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
public class ProductResponse { //consume productResponse from queue
	
	private ProductRequest product;
	private String message;
	
	public ProductResponse() {
		
	}
	
	
	public ProductResponse(ProductRequest product, String message) {
		super();
		this.product = product;
		this.message = message;
	}
	public ProductRequest getProduct() {
		return product;
	}
	public void setProduct(ProductRequest product) {
		this.product = product;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
