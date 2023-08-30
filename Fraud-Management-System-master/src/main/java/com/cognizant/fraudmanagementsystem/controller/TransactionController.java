package com.cognizant.fraudmanagementsystem.controller;

import com.cognizant.fraudmanagementsystem.model.Transaction;
import com.cognizant.fraudmanagementsystem.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transaction")
    public String showTransactionPage(ModelMap model) {
        model.addAttribute("transactions",transactionService.getAllTransactions());
        return "fraud/transactions";
    }

    @GetMapping(value = "/add-transaction-fraud")
    public String showAddTransactionFraudPage(ModelMap model) {
        model.addAttribute("transaction", new Transaction());
        return "fraud/add-transaction";
    }

    @PostMapping(value = "/add-transaction-fraud")
    public String addTransactionFraud(
        ModelMap model,
        Transaction transaction
    ) {
        if (transactionService.addTransaction(transaction)) {
            return "redirect:/transaction";
        } else {
            model.put("error", "Coundn't add transaction");
            return "redirect:/transaction";
        }
    }

    @PostMapping(value = "/transaction-delete")
	public String deleteTransaction(String id) {
        System.out.println("Transaction is being deleted...");
		Transaction transaction = transactionService.getTransactionById(Integer.valueOf(id));
		transactionService.delete(transaction);
		return "redirect:/transaction";
	}

    @PostMapping(value = "/transaction-search")
    public String transactionSearch(ModelMap model, String query, String type) {
        model.addAttribute("transactions",transactionService.searchTransactions(query, type));
        return "fraud/transactions";
    }

}