package com.tinybank.apiservice.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Represents a bank account balance")
public final class BalanceDTO {

    @Schema(description = "The current balance amount.", example = "256,86")
    private double balance;

    public BalanceDTO() {}

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
