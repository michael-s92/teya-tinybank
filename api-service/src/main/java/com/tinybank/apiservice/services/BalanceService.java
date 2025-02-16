package com.tinybank.apiservice.services;

import com.tinybank.apiservice.interfaces.IBalanceService;
import com.tinybank.entities.Balance;
import com.tinybank.interfaces.IBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService implements IBalanceService {

    private final IBalanceRepository balanceRepository;

    @Autowired
    public BalanceService(IBalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    public Balance viewBalance() {
        return balanceRepository.getBalance();
    }
}
