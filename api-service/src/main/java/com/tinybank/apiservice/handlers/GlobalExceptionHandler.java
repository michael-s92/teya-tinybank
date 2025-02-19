package com.tinybank.apiservice.handlers;

import com.tinybank.apiservice.handlers.errors.BankInternalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BankInternalException.class)
    public ResponseEntity<Map<String, Object>> handleBankInternalException(BankInternalException ex) {
        logger.error(ex.getMessage(), ex);

        Map<String, Object> errorResponse = new HashMap<String, Object>();
        errorResponse.put("timestamp", LocalDateTime.now().toString());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("error", "bank internal server error");
        errorResponse.put("message", ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(final Exception ex) {
        logger.error(ex.getMessage(), ex);

        Map<String, Object> errorResponse = new HashMap<String, Object>();
        errorResponse.put("timestamp", LocalDateTime.now().toString());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("error", "internal server error");
        errorResponse.put("message", ex.getMessage());
        //errorResponse.put("stacktrace", ex.getStackTrace());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
