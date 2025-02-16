package com.tinybank.repositories;

import com.tinybank.entities.Balance;
import com.tinybank.inmemory.InMemoryData;
import com.tinybank.interfaces.IBalanceRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceRepository implements IBalanceRepository {

    @Override
    public Balance getBalance() {
        return InMemoryData.getInstance().getBalance();
    }

    @Override
    public void updateBalance(double amount) {
        var balance = InMemoryData.getInstance().getBalance();
        var oldAmount = balance.getValue();
        balance.setValue(oldAmount + amount);
    }
}
