package com.tinybank.apiservice.requests;

import lombok.Data;

@Data
public class TransactionRequest {

    private double amount;

    public TransactionRequest() {}

    public double getAmount() {
        return amount;
    }
}
