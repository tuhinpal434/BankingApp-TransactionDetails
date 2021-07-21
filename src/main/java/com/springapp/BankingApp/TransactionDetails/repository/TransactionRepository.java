package com.springapp.BankingApp.TransactionDetails.repository;

import com.springapp.BankingApp.TransactionDetails.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findAllByaccountNumber(long accountNumber);
}
