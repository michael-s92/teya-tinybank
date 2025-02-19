package com.tinybank.apiservice.responses;

import com.tinybank.apiservice.mappers.TransactionMapper;
import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
public class TransactionUpToDateDTO {

    private List<TransactionDTO> transactions;
    private double balance;

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }

    public TransactionUpToDateDTO(double balance, List<TransactionDTO> transactions){
        this.balance = balance;
        this.transactions = transactions;
    }
}
