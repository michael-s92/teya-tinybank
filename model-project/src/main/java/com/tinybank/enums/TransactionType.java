package com.tinybank.enums;

import lombok.Getter;

public enum TransactionType {
    WITHDRAWAL("withdrawal"),
    DEPOSIT("deposit"),;

    @Getter
    private final String name;

    TransactionType(String name) {
        this.name = name;
    }
}
