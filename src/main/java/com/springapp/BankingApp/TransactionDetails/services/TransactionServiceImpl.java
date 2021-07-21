package com.springapp.BankingApp.TransactionDetails.services;

import com.springapp.BankingApp.TransactionDetails.VO.ResponseEntityVO;
import com.springapp.BankingApp.TransactionDetails.entity.Account;
import com.springapp.BankingApp.TransactionDetails.entity.Transaction;
import com.springapp.BankingApp.TransactionDetails.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TransactionRepository transactionRepository;




    @Override
    public long deposit(long accountNumber, long amount) {
        Transaction transaction = new Transaction();
        System.out.println(accountNumber);
        ResponseEntityVO vo = restTemplate.getForObject("http://ACCOUNT-SERVICE/account/" + accountNumber,
                ResponseEntityVO.class);
        Account account = null;
        if (vo != null) {
            account = vo.getAccount();
        }
        System.out.println(account);
        long currentBalance = 0;
        if (account != null) {
            currentBalance = account.getAccountBalance()+amount;
            restTemplate.put("http://ACCOUNT-SERVICE/account/balanceUpdate/"+accountNumber+"/"+currentBalance,Long.class);
            transaction.setTransactionType("Deposit");
            transaction.setTransactionAmount(amount);
            transaction.setAccountNumber(account.getAccountNumber());
            transactionRepository.save(transaction);
        }


       return currentBalance;
    }

    @Override
    public long withdraw(long accountNumber, long amount) {
        Transaction transaction = new Transaction();
        ResponseEntityVO vo = restTemplate.getForObject("http://ACCOUNT-SERVICE/account/" + accountNumber,
                ResponseEntityVO.class);
        Account account = null;
        if (vo != null) {
            account = vo.getAccount();
        }
        long currentBalance = 0;
        if (account != null) {

            if(account.getAccountBalance()>amount) {
                currentBalance = account.getAccountBalance() - amount;
                restTemplate.put("http://ACCOUNT-SERVICE/account/balanceUpdate/" + accountNumber + "/" + currentBalance, Long.class);
                transaction.setTransactionType("Withdraw");
                transaction.setTransactionAmount(amount);
                transaction.setAccountNumber(account.getAccountNumber());
                transactionRepository.save(transaction);
            }
        }


        return currentBalance;
    }

    @Override
    public List<Transaction> getAllByAccountNumber(long accountNumber) {
        return transactionRepository.findAllByaccountNumber(accountNumber);
    }
}
