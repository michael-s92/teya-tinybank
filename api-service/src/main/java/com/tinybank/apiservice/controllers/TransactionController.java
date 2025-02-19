package com.tinybank.apiservice.controllers;

import com.tinybank.apiservice.helpers.TransactionHelper;
import com.tinybank.apiservice.interfaces.ITransactionService;
import com.tinybank.apiservice.mappers.TransactionMapper;
import com.tinybank.apiservice.requests.TransactionRequest;
import com.tinybank.apiservice.responses.TransactionHistoryDTO;
import com.tinybank.apiservice.responses.TransactionUpToDateDTO;
import com.tinybank.entities.TransactionUpToDate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/transaction")
@Tag(name = "Transaction Controller", description = "Controller for handling transaction operation.")
public class TransactionController {

    private ITransactionService transactionService;

    private final String transactionFinishMessage = "Transaction finished successfully.";

    @Autowired
    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary = "View Transaction History", description = "Get list of all transactions.")
    @GetMapping(value = "/history", produces = "application/json")
    public ResponseEntity<TransactionHistoryDTO> getTransactionHistory(){

        var response = this.transactionService.getHistory();
        return ResponseEntity.ok(TransactionMapper.toHistoryDTO(response));
    }

    @Operation(summary = "Deposit", description = "Deposit money transaction.")
    @PostMapping(value = "/deposit", produces = "application/json")
    public ResponseEntity<String> deposit(@RequestBody TransactionRequest request) {

        this.transactionService.execute(TransactionHelper.createDepositTransaction(request.getAmount()));
        return ResponseEntity.ok(transactionFinishMessage);
    }

    @Operation(summary = "Withdraw", description = "Withdraw money transaction.")
    @PostMapping(value = "/withdraw", produces = "application/json")
    public ResponseEntity<String> withdraw(@RequestBody TransactionRequest request) {

        this.transactionService.execute(TransactionHelper.createWithdrawTransaction(request.getAmount()));
        return ResponseEntity.ok(transactionFinishMessage);
    }

    @Operation(summary = "View Transaction History", description = "Get list of all transactions.")
    @GetMapping(value = "/history/{datetime}", produces = "application/json")
    public ResponseEntity<TransactionUpToDateDTO> getTransactionHistoryUpToDate(@PathVariable final LocalDateTime datetime){

        TransactionUpToDate response = this.transactionService.getHistoryUpToDate(datetime);
        return ResponseEntity.ok(TransactionMapper.toUpToHistoryDTO(response));
    }
}
