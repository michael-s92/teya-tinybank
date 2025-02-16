package com.tinybank.apiservice.responses;

import com.tinybank.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Represents a transaction")
public final class TransactionDTO {

    @Schema(description = "The type of transaction. It can be deposit or withdraw.", example = "DEPOSIT")
    private String type;

    @Schema(description = "The value of the transaction.", example = "15,67")
    private double amount;

    public TransactionDTO(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
