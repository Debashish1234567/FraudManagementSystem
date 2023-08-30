package com.cognizant.fraudmanagementsystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.cognizant.fraudmanagementsystem.model.Transaction;
import com.cognizant.fraudmanagementsystem.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAllTransactions();
    }

    public Transaction getTransactionById(int id) {
        return getAllTransactions().stream().filter(transaction -> transaction.getId() == id).findAny().get();
    }

    public void delete(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    public boolean addTransaction(Transaction transaction) {
        try {
            transactionRepository.addTransaction(transaction);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Transaction> searchTransactions(String query, String type) {
        if (type.equals("cardType")) {
            return getAllTransactions().stream().filter(card -> card.getCardType().equalsIgnoreCase(query)).collect(Collectors.toList());
        }
        if (type.equals("userId")) {
            return getAllTransactions().stream().filter(card -> card.getUserId().equals(query)).collect(Collectors.toList());
        }
        if (type.equals("fraudLevel")) {
            return getAllTransactions().stream().filter(card -> card.getFraudLevel().equalsIgnoreCase(query)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

}
