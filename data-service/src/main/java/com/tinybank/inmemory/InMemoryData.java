package com.tinybank.inmemory;

import com.tinybank.entities.Balance;
import com.tinybank.entities.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class InMemoryData {
    // in memory data
    @Getter
    private Balance balance;

    @Getter
    private List<Transaction> transactions;
    // --------------------

    private InMemoryData() {
        balance = new Balance();
        transactions = new ArrayList<>();
    }

    // implementation of HolderClass Singleton
    private static final class InstanceHolder {
        private static final InMemoryData instance = new InMemoryData();
    }

    public static InMemoryData getInstance() {
        return InstanceHolder.instance;
    }
}
