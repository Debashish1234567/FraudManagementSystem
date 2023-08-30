package com.cognizant.fraudmanagementsystem.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.fraudmanagementsystem.model.Card;
import com.cognizant.fraudmanagementsystem.repositories.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CardServiceTest {

    @Autowired
    private CardService service;

    @MockBean
    private CardRepository repository;

    private List<Card> cards;

    @BeforeEach 
    public void setup() {
        cards = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Card card = new Card();
            card.setId(i);
            cards.add(card);
        }
        when(repository.getAllCards()).thenReturn(cards);
    }

    @Test
    void testAddCard() {
        Card card = new Card();
        card.setId(11);
        doAnswer(answer -> { 
            cards.add(card);
            assertEquals(card, service.getCardById(11));
            return null;
        }).when(repository).addCard(card);
    }

    @Test
    void testGetAllCards() {
        assertEquals(10,service.getAllCards().size());
    }

    @Test
    void testGetCardById() {
        assertEquals(cards.get(0), service.getCardById(0));
    }

}
