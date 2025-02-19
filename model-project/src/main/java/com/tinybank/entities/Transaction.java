package com.tinybank.entities;

import com.tinybank.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public final class Transaction {

    @Getter
    @Setter
    private TransactionType type;

    @Getter
    @Setter
    private double amount;

    @Getter
    @Setter
    private LocalDateTime timestamp;
}
