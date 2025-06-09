package com.example.pasir_szymik_dawid.controller;

import com.example.pasir_szymik_dawid.dto.BalanceDTO;
import com.example.pasir_szymik_dawid.dto.TransactionDTO;
import com.example.pasir_szymik_dawid.model.Transaction;
import com.example.pasir_szymik_dawid.model.User;
import com.example.pasir_szymik_dawid.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

import java.util.List;

@Controller
public class TransactionGraphQLController {

    private final TransactionService transactionService;

    public TransactionGraphQLController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @QueryMapping
    public List<Transaction> transactions() {
        return transactionService.getAllTransactions();
    }

    @MutationMapping
    public Transaction addTransaction(@Valid @Argument TransactionDTO transactionDTO) {
        return transactionService.createTransaction(transactionDTO);
    }

    @MutationMapping
    public Transaction updateTransaction(
            @Argument Long id,
            @Valid @Argument TransactionDTO transactionDTO
    ) {
        return transactionService.updateTransaction(id, transactionDTO);
    }

    @MutationMapping
    public Transaction deleteTransaction(@Argument Long id) {
        return transactionService.deleteTransaction(id);
    }

    @QueryMapping
    public BalanceDTO userBalance(@Argument Float days) {
        User user = transactionService.getCurrentUser();
        return transactionService.getUserBalance(user, days);
    }
}
