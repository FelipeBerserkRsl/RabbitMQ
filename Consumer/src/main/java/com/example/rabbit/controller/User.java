package com.example.rabbit.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbit.config.Rabbitconfig;
import com.example.rabbit.model.Product;

@Component
public class User {

	@RabbitListener(queues = Rabbitconfig.FELIPE_QUEUE)
	public void consumeMessageFromQueue(Product product) {
		System.out.println("Message Recieved from queue: " + product);
	}
}
