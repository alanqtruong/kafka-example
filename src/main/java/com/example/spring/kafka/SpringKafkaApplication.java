package com.example.spring.kafka;

import com.example.spring.kafka.producer.KafkaMessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 *  @author recklessN1nja
 */
@SpringBootApplication(scanBasePackages = "com.example.spring.kafka")
public class SpringKafkaApplication {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(SpringKafkaApplication.class, args);

		KafkaMessageProducer producer = context.getBean(KafkaMessageProducer.class);

		ListenableFuture<SendResult<String, String>> future = producer.send("Hello, World!");

		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println("Message successfully sent");
			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Message fail to sent");
			}
		});

		Thread.sleep(10000);
		context.close();
	}
}