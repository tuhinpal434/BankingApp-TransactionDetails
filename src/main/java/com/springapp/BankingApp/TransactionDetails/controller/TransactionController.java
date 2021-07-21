package com.springapp.BankingApp.TransactionDetails.controller;

import com.springapp.BankingApp.TransactionDetails.entity.Transaction;
import com.springapp.BankingApp.TransactionDetails.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit/{accountNumber}/{amount}")
    public long deposit(@PathVariable("accountNumber") long accountNumber, @PathVariable("amount") long amount){
        return transactionService.deposit(accountNumber,amount);

    }

    @PostMapping("/withdraw/{accountNumber}/{amount}")
    public long withdraw(@PathVariable("accountNumber") long accountNumber, @PathVariable("amount") long amount){
        return transactionService.withdraw(accountNumber,amount);

    }

    @GetMapping("/{accountNumber}")
    public List<Transaction> getTransactionByAccountNumber(@PathVariable("accountNumber") long accountNumber){
        return transactionService.getAllByAccountNumber(accountNumber);
    }
}
