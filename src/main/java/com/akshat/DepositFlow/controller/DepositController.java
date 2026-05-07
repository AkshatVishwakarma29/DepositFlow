package com.akshat.DepositFlow.controller;

import com.akshat.DepositFlow.model.Deposit;
import com.akshat.DepositFlow.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deposits")
public class DepositController {

    @Autowired
    private DepositService depositService;

    // POST /api/deposits — create new FD
    @PostMapping
    public Deposit createDeposit(@RequestBody Deposit deposit) {
        return depositService.createDeposit(deposit);
    }

    // GET /api/deposits — get all FDs
    @GetMapping
    public List<Deposit> getAllDeposits() {
        return depositService.getAllDeposits();
    }

    // GET /api/deposits/1 — get FD by ID
    @GetMapping("/{id}")
    public Deposit getDepositById(@PathVariable Long id) {
        return depositService.getDepositById(id);
    }

    // GET /api/deposits/1/maturity — calculate maturity
    @GetMapping("/{id}/maturity")
    public double calculateMaturity(@PathVariable Long id) {
        return depositService.calculateMaturity(id);
    }

    // PUT /api/deposits/1/withdraw — withdraw FD
    @PutMapping("/{id}/withdraw")
    public Deposit withdraw(@PathVariable Long id) {
        return depositService.withdraw(id);
    }

}
