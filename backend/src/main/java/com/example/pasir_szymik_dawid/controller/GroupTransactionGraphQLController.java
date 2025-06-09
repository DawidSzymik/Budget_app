package com.example.pasir_szymik_dawid.controller;

import com.example.pasir_szymik_dawid.dto.GroupTransactionDTO;
import com.example.pasir_szymik_dawid.model.User;
import com.example.pasir_szymik_dawid.service.GroupTransactionService;
import com.example.pasir_szymik_dawid.service.TransactionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GroupTransactionGraphQLController {

    private final GroupTransactionService groupTransactionService;
    private final TransactionService transactionService;

    public GroupTransactionGraphQLController(GroupTransactionService groupTransacionService, TransactionService transactionService) {
        this.groupTransactionService = groupTransacionService;
        this.transactionService = transactionService;
    }

    @MutationMapping
    public Boolean addGroupTransaction(@Argument GroupTransactionDTO groupTransactionDTO) {
        User user = transactionService.getCurrentUser();
        groupTransactionService.addGroupTransaction(groupTransactionDTO, user);
        return true;
    }
}
