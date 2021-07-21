package com.springapp.BankingApp.TransactionDetails.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {


    private long accountNumber;

    private String accountType;
    private long accountBalance;
    private long accountHolderUserId;
}

