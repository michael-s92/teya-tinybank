package com.tinybank.apiservice.helpers;

import com.tinybank.entities.Transaction;
import com.tinybank.enums.TransactionType;

public final class TransactionHelper {

    public static Transaction createDepositTransaction(final double amount){
        var txn = new Transaction();
        txn.setAmount(Math.abs(amount));
        txn.setType(TransactionType.DEPOSIT);
        return txn;
    }

    public static Transaction createWithdrawTransaction(final double amount){
        var txn = new Transaction();
        txn.setAmount(Math.abs(amount));
        txn.setType(TransactionType.WITHDRAWAL);
        return txn;
    }
}
