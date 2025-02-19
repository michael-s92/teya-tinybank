package com.tinybank.apiservice.helpers;

import com.tinybank.apiservice.handlers.errors.BankInternalException;
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

    public static Transaction createTransaction(final String type, final double amount){
        if(type.equals("DEPOSIT")){
            return createDepositTransaction(amount);
        } else if(type.equals("WITHDRAWAL")){
            return createWithdrawTransaction(amount);
        }
        throw new BankInternalException("Unknown transaction type");
    }
}
