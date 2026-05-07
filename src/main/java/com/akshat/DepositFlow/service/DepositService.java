package com.akshat.DepositFlow.service;

import com.akshat.DepositFlow.model.Deposit;
import com.akshat.DepositFlow.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    // Create a new FD
    public Deposit createDeposit(Deposit deposit) {
        deposit.setStatus("ACTIVE");
        return depositRepository.save(deposit);
    }

    // Get all deposits
    public List<Deposit> getAllDeposits() {
        return depositRepository.findAll();
    }

    // Get deposit by ID
    public Deposit getDepositById(Long id) {
        return depositRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deposit not found with id: " + id));
    }

    // Calculate maturity amount
    // Formula: P * (1 + r/100/12) ^ months
    public double calculateMaturity(Long id) {
        Deposit deposit = getDepositById(id);
        double p = deposit.getPrincipal();
        double r = deposit.getInterestRate();
        int n = deposit.getTenureMonths();
        return p * Math.pow((1 + r / 100 / 12), n);
    }

    // Withdraw FD
    public Deposit withdraw(Long id) {
        Deposit deposit = getDepositById(id);
        if (deposit.getStatus().equals("WITHDRAWN")) {
            throw new RuntimeException("Deposit already withdrawn");
        }
        deposit.setStatus("WITHDRAWN");
        return depositRepository.save(deposit);
    }

}
