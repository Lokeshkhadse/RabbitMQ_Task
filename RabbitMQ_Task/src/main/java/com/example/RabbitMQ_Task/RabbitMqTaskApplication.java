package com.example.RabbitMQ_Task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMqTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqTaskApplication.class, args);
	}

}
