package com.tinybank.apiservice.kafka;

import com.tinybank.apiservice.helpers.TransactionHelper;
import com.tinybank.apiservice.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {
    private final ITransactionService transactionService;

    @Autowired
    public TransactionConsumer(final ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @KafkaListener(topics = "${kafka.topic.transaction}", groupId = "${spring.kafka.consumer.group-id}")
    public void processTransaction(String message) {
        var parts = message.split(",");
        String type = parts[0];
        double amount = Double.parseDouble(parts[1]);

        transactionService.execute(TransactionHelper.createTransaction(type, amount));
    }
}
