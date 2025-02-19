package com.tinybank.entities;

import lombok.Data;

import java.util.List;

@Data
public class TransactionUpToDate {

    private double balance;
    private List<Transaction> txns;
}
