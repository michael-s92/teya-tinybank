package com.tinybank.apiservice.mappers;

import com.tinybank.apiservice.responses.BalanceDTO;
import com.tinybank.entities.Balance;

public final class BalanceMapper {

    private BalanceMapper() {}

    public static BalanceDTO toDTO(Balance balance) {
        var dto = new BalanceDTO();
        dto.setBalance(balance.getValue());
        return dto;
    }
}
