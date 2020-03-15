package com.apnatriangle.springkafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

	@Autowired
	private KafkaTemplate<String, String> template;

	@KafkaListener(topics = "topic1")
	public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println(cr.toString());
	}
}
