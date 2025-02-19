package com.tinybank.interfaces;

import com.tinybank.entities.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface ITransactionRepository {

    List<Transaction> getHistory();

    void storeTransaction(Transaction txn);

    List<Transaction> getAllUpToDate(LocalDateTime datetime);
}
