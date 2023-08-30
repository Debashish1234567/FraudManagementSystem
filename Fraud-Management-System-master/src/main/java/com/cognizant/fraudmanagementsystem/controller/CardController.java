package com.cognizant.fraudmanagementsystem.controller;

import com.cognizant.fraudmanagementsystem.model.Card;
import com.cognizant.fraudmanagementsystem.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CardController {
    
    @Autowired
    private CardService cardService;

    @GetMapping(value = "/card")
    public String showCardPage(ModelMap model) {
        model.addAttribute("cards",cardService.getAllCards());
        return "fraud/cards";
    }

    @GetMapping(value = "/add-card-fraud")
    public String showAddCardFraudPage(ModelMap model) {
        model.addAttribute("card", new Card());
        return "fraud/add-card";
    }

    @PostMapping(value = "/add-card-fraud")
    public String addCardFraud(
        ModelMap model,
        Card card
    ) {
        if (cardService.addCard(card)) {
            return "redirect:/card";
        } else {
            model.put("error", "Coundn't add card");
            return "redirect:/card";
        }
    }

    @PostMapping(value = "/card-delete")
	public String deleteCard(String id) {
        System.out.println("Card is being deleted...");
		Card card = cardService.getCardById(Integer.valueOf(id));
		cardService.delete(card);
		return "redirect:/card";
	}

    @PostMapping(value = "/card-search")
    public String cardSearch(ModelMap model, String query, String type) {
        model.addAttribute("cards",cardService.searchCards(query, type));
        return "fraud/cards";
    }

}
