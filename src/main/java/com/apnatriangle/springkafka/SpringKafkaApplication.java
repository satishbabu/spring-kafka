package com.apnatriangle.springkafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

	@KafkaListener(topics = "topic1")
	public void listen(ConsumerRecord<?, ?> cr) {
		System.out.println(cr.toString());
	}
}
