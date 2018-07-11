package com.example.spring.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author recklessN1nja
 */
public class KafkaMessageListener {

    @KafkaListener(topics = "${message.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void topicListener(String message) {
        System.out.println("Received Messasge: " + message);
    }
}
