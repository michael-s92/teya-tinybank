package com.tinybank.apiservice.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Represents the transaction that should be executed.")
public class TransactionRequest {

    @Schema(description = "The value of the transaction. Lets assume its always positive number.")
    private double amount;

    public TransactionRequest() {}

    public double getAmount() {
        return amount;
    }
}
