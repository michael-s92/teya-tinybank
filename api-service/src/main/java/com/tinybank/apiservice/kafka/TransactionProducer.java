package com.tinybank.apiservice.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.transaction}")
    private String topic;

    public TransactionProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTransaction(String transactionType, double amount) {
        var msg = transactionType.toUpperCase() + ", " + amount;
        kafkaTemplate.send(topic, msg);
    }
}
