package com.tinybank.interfaces;

import com.tinybank.entities.Balance;

public interface IBalanceRepository {

    Balance getBalance();

    void updateBalance(double amount);
}
