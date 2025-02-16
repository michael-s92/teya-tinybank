package com.tinybank.apiservice.services;

import com.tinybank.apiservice.interfaces.ITransactionService;
import com.tinybank.entities.Transaction;
import com.tinybank.enums.TransactionType;
import com.tinybank.interfaces.IBalanceRepository;
import com.tinybank.interfaces.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    private final ITransactionRepository transactionRepository;
    private final IBalanceRepository balanceRepository;

    @Autowired
    public TransactionService(ITransactionRepository transactionRepository, IBalanceRepository balanceRepository) {
        this.transactionRepository = transactionRepository;
        this.balanceRepository = balanceRepository;
    }

    @Override
    public List<Transaction> getHistory() {
        return transactionRepository.getHistory();
    }

    @Override
    public void execute(Transaction txn) {
        var amount = txn.getAmount();
        if (txn.getType().equals(TransactionType.WITHDRAWAL)) {
            amount = -amount;
        }

        balanceRepository.updateBalance(amount);
        transactionRepository.storeTransaction(txn);
    }
}
