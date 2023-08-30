package com.cognizant.fraudmanagementsystem.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.fraudmanagementsystem.model.Claim;
import com.cognizant.fraudmanagementsystem.repositories.ClaimRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ClaimServiceTest {

    @Autowired
    private ClaimService service;

    @MockBean
    private ClaimRepository repository;

    private List<Claim> claims;

    @BeforeEach 
    public void setup() {
        claims = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Claim claim = new Claim();
            claim.setId(i);
            claims.add(claim);
        }
        when(repository.getAllClaims()).thenReturn(claims);
    }

    @Test
    void testAddCard() {
        Claim claim = new Claim();
        claim.setId(11);
        doAnswer(answer -> { 
            claims.add(claim);
            assertEquals(claim, service.getClaimById(11));
            return null;
        }).when(repository).addClaim(claim);
    }

    @Test
    void testGetAllCards() {
        assertEquals(10,service.getAllClaims().size());
    }

    @Test
    void testGetCardById() {
        assertEquals(claims.get(0), service.getClaimById(0));
    }

}
