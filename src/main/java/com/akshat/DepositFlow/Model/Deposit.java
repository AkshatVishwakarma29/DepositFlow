package com.akshat.DepositFlow.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;
    private double principal; // amount deposited
    private double interestRate; // annual rate e.g. 7.5
    private int tenureMonths; // duration in months
    private String status; // ACTIVE, WITHDRAWN

}