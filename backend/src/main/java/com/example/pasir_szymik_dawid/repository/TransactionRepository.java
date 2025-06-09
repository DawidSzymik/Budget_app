package com.example.pasir_szymik_dawid.repository;

import com.example.pasir_szymik_dawid.model.Transaction;
import com.example.pasir_szymik_dawid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
}
