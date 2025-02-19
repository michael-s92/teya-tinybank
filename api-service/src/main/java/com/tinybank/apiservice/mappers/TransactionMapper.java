package com.tinybank.apiservice.mappers;

import com.tinybank.apiservice.responses.TransactionDTO;
import com.tinybank.apiservice.responses.TransactionHistoryDTO;
import com.tinybank.apiservice.responses.TransactionUpToDateDTO;
import com.tinybank.entities.Transaction;
import com.tinybank.entities.TransactionUpToDate;

import java.util.ArrayList;
import java.util.List;

public final class TransactionMapper {

    private TransactionMapper() {}

    public static TransactionHistoryDTO toHistoryDTO(List<Transaction> transactions) {

        var transactionsDTO = new ArrayList<TransactionDTO>();
        for (var transaction : transactions) {
            transactionsDTO.add(toTransactionDTO(transaction));
        }
        return new TransactionHistoryDTO(transactionsDTO);
    }

    public static TransactionDTO toTransactionDTO(Transaction transaction) {
        return new TransactionDTO(transaction.getType().toString(), transaction.getAmount());
    }

    public static TransactionUpToDateDTO toUpToHistoryDTO(TransactionUpToDate response) {
        var transactionDTOs = new ArrayList<TransactionDTO>();
        for (var txn: response.getTxns()){
            transactionDTOs.add(toTransactionDTO(txn));
        }
        return new TransactionUpToDateDTO(response.getBalance(), transactionDTOs);
    }
}
