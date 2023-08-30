package com.cognizant.fraudmanagementsystem.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.fraudmanagementsystem.model.Transaction;
import com.cognizant.fraudmanagementsystem.repositories.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private TransactionService service;

    @MockBean
    private TransactionRepository repository;

    private List<Transaction> transactions;

    @BeforeEach 
    public void setup() {
        transactions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Transaction transaction = new Transaction();
            transaction.setId(i);
            transactions.add(transaction);
        }
        when(repository.getAllTransactions()).thenReturn(transactions);
    }

    @Test
    void testAddCard() {
        Transaction transaction = new Transaction();
        transaction.setId(11);
        doAnswer(answer -> { 
            transactions.add(transaction);
            assertEquals(transaction, service.getTransactionById(11));
            return null;
        }).when(repository).addTransaction(transaction);
    }

    @Test
    void testGetAllCards() {
        assertEquals(10,service.getAllTransactions().size());
    }

    @Test
    void testGetCardById() {
        assertEquals(transactions.get(0), service.getTransactionById(0));
    }

}

