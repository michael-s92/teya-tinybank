package com.tinybank.apiservice.controllers;

import com.tinybank.apiservice.helpers.TransactionHelper;
import com.tinybank.apiservice.interfaces.ITransactionService;
import com.tinybank.entities.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@RestController
@RequestMapping("/setup")
@Tag(name = "Setup Controller", description = "Controller for handling operation for easier testing.")
public class SetupController {

    private final ITransactionService transactionService;
    private final Random random = new Random();

    @Autowired
    public SetupController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary = "Random Data Setup", description = "Publish random number of transaction in the system.")
    @GetMapping("/random")
    public ResponseEntity<String> randomSetupInMemoryData() {
        var count = random.nextInt(2, 10);

        for (int i = 0; i < count; i++) {
            var amount = BigDecimal
                    .valueOf(random.nextDouble(100))
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            
            Transaction txn;
            if(Math.round(amount) % 2 == 0) {
                txn = TransactionHelper.createDepositTransaction(amount);
            } else {
                txn = TransactionHelper.createWithdrawTransaction(amount);
            }

            this.transactionService.execute(txn);
        }

        return ResponseEntity.ok("Generated: " + count + " Transactions.");
    }
}
