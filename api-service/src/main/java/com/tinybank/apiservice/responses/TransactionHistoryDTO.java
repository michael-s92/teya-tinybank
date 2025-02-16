package com.tinybank.apiservice.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Schema(description = "Represents the list of all executed transaction in the bank.")
public final class TransactionHistoryDTO {

    @Schema(description = "The indicator how many transaction are executed.", example = "7")
    private int numberOfTransactions;

    @Schema(description = "The list of all executed transactions.")
    private List<TransactionDTO> transactions;

    public TransactionHistoryDTO(List<TransactionDTO> transactions) {
        this.transactions = transactions;
        this.numberOfTransactions = transactions.size();
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(int numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }
}
