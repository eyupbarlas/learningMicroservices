package com.example.fraud.controller;

import com.example.clients.fraud.response.FraudCheckResponse;
import com.example.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/fraud-check")
public class FraudCheckController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId) {
        boolean isCustomerFraud = fraudCheckService.isCustomerFraud(customerId);
        log.info("fraud check request for customer {}", customerId);

        return new FraudCheckResponse(isCustomerFraud);
    }
}
