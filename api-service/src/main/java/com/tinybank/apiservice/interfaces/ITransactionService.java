package com.tinybank.apiservice.interfaces;

import com.tinybank.entities.Transaction;
import com.tinybank.entities.TransactionUpToDate;

import java.time.LocalDateTime;
import java.util.List;

public interface ITransactionService {

    List<Transaction> getHistory();

    void execute(Transaction txn);

    TransactionUpToDate getHistoryUpToDate(LocalDateTime datetime);
}
