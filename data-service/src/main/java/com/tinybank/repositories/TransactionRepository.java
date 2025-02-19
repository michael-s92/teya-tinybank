package com.tinybank.repositories;

import com.tinybank.entities.Transaction;
import com.tinybank.inmemory.InMemoryData;
import com.tinybank.interfaces.ITransactionRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TransactionRepository implements ITransactionRepository {

    @Override
    public List<Transaction> getHistory() {
        return InMemoryData.getInstance().getTransactions();
    }

    @Override
    public void storeTransaction(Transaction txn) {
        InMemoryData.getInstance().getTransactions().add(txn);
    }

    @Override
    public List<Transaction> getAllUpToDate(LocalDateTime datetime) {
        return InMemoryData.getInstance().getTransactions().stream()
                .filter(txn -> txn.getTimestamp().isBefore(datetime))
                .toList();
    }
}
