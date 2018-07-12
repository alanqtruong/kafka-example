package com.example.spring.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Setup a message producer for the given topic
 * @author recklessN1nja
 */
public class KafkaMessageProducer {

    @Value("${message.topic.name}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public ListenableFuture<SendResult<String, String>> send(String message){
        return kafkaTemplate.send(topic, message);
    }
}
