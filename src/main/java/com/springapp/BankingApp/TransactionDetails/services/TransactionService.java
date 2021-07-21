package com.springapp.BankingApp.TransactionDetails.services;

import com.springapp.BankingApp.TransactionDetails.entity.Transaction;

import java.util.List;

public interface TransactionService {
    long deposit(long accountNumber, long amount);

    long withdraw(long accountNumber, long amount);

    List<Transaction> getAllByAccountNumber(long accountNumber);
}
