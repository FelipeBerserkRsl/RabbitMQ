package com.example.rabbit.controller;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbit.config.Rabbitconfig;
import com.example.rabbit.model.Product;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private RabbitTemplate template;
	
	@PostMapping
	public String bookOrder(@RequestBody Product product) {
		product.setId(UUID.randomUUID().toString());
		template.convertAndSend(Rabbitconfig.FELIPE_EXCHANGE, Rabbitconfig.FELIPE_ROUTING, product);
		
		return "Success !! ";
	}
 
}
