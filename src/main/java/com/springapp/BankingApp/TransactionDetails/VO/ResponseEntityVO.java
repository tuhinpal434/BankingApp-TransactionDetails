package com.springapp.BankingApp.TransactionDetails.VO;

import com.springapp.BankingApp.TransactionDetails.entity.Account;
import com.springapp.BankingApp.TransactionDetails.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntityVO {

    private Account account;
    private List<Transaction> transactions;
}
