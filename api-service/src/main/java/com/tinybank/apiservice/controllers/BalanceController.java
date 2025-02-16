package com.tinybank.apiservice.controllers;

import com.tinybank.apiservice.interfaces.IBalanceService;
import com.tinybank.apiservice.mappers.BalanceMapper;
import com.tinybank.apiservice.responses.BalanceDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
@Tag(name = "Balance Controller", description = "Controller for handling balance operation.")
public class BalanceController {

    private final IBalanceService balanceService;

    @Autowired
    public BalanceController(IBalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @Operation(summary = "View balance", description = "Get endpoint to view current balance in the bank.")
    @GetMapping(value = "/view", produces = "application/json")
    public ResponseEntity<BalanceDTO> viewBalance() {

        var response = this.balanceService.viewBalance();
        var responseDto = BalanceMapper.toDTO(response);
        return ResponseEntity.ok(responseDto);
    }
}
