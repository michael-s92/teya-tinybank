package com.tinybank.apiservice.controllers;

import com.tinybank.TinyBankMessages;
import com.tinybank.apiservice.interfaces.ITransactionService;
import com.tinybank.apiservice.kafka.TransactionProducer;
import com.tinybank.apiservice.mappers.TransactionMapper;
import com.tinybank.apiservice.requests.TransactionRequest;
import com.tinybank.apiservice.responses.TransactionHistoryDTO;
import com.tinybank.enums.TransactionType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@Tag(name = "Transaction Controller", description = "Controller for handling transaction operation.")
public class TransactionController {

    private final ITransactionService transactionService;
    private final TransactionProducer transactionProducer;

    @Autowired
    public TransactionController(ITransactionService transactionService, TransactionProducer transactionProducer) {
        this.transactionService = transactionService;
        this.transactionProducer = transactionProducer;
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

        transactionProducer.sendTransaction(TransactionType.DEPOSIT.getName(), request.getAmount());
        return ResponseEntity.ok(TinyBankMessages.depositRequestReceived);
    }

    @Operation(summary = "Withdraw", description = "Withdraw money transaction.")
    @PostMapping(value = "/withdraw", produces = "application/json")
    public ResponseEntity<String> withdraw(@RequestBody TransactionRequest request) {

        transactionProducer.sendTransaction(TransactionType.WITHDRAWAL.getName(), request.getAmount());
        return ResponseEntity.ok(TinyBankMessages.withdrawRequestReceived);
    }
}
