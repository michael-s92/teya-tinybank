package com.tinybank.apiservice.interfaces;

import com.tinybank.entities.Transaction;

import java.util.List;

public interface ITransactionService {

    List<Transaction> getHistory();

    void execute(Transaction txn);
}
