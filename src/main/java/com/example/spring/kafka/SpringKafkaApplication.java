package com.example.spring.kafka;

import com.example.spring.kafka.producer.KafkaMessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *  @author recklessN1nja
 */
@SpringBootApplication(scanBasePackages = "com.example.spring.kafka")
public class SpringKafkaApplication {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(SpringKafkaApplication.class, args);

		KafkaMessageProducer producer = context.getBean(KafkaMessageProducer.class);

		producer.send("Hello, World!");
		Thread.sleep(10000);
		context.close();
	}
}