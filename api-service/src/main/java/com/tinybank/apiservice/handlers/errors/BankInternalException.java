package com.tinybank.apiservice.handlers.errors;

public class BankInternalException extends RuntimeException {

    public BankInternalException(String message) {
        super(message);
    }
}
