package com.tinybank.entities;

import com.tinybank.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

public final class Transaction {

    @Getter
    @Setter
    private TransactionType type;

    @Getter
    @Setter
    private double amount;
}
