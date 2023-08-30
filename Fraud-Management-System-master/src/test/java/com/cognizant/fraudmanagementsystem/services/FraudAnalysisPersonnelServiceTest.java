package com.cognizant.fraudmanagementsystem.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.fraudmanagementsystem.model.FraudAnalysisPersonnel;
import com.cognizant.fraudmanagementsystem.repositories.FraudAnalysisPersonnelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class FraudAnalysisPersonnelServiceTest {

    @Autowired
    private FraudAnalysisPersonnelService service;

    @MockBean
    private FraudAnalysisPersonnelRepository repository;

    @Mock
    private List<FraudAnalysisPersonnel> personnels;

    @BeforeEach
    public void setup() {
        personnels = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			FraudAnalysisPersonnel personnel= new FraudAnalysisPersonnel();
			personnel.setId("id" + i);
			personnel.setPassword("password" + i);
            personnel.setFirstAnswer("firstAnswer" + i);
            personnel.setSecondAnswer("secondAnswer" + i);
            personnel.setThirdAnswer("thirdAnswer" + i);
			personnels.add(personnel);
		}
        when(repository.getAllFraudAnalysisPersonnels()).thenReturn(personnels);
    }

    @Test
    void testAddAdmin() {
        FraudAnalysisPersonnel personnel= new FraudAnalysisPersonnel();
        personnel.setId("id11");
        personnel.setPassword("password11");
        doAnswer(answer -> { 
            personnels.add(personnel);
            assertEquals(true, service.isValid("id11", "password11"));
            return null;
        }).when(repository).addFraudAnalysisPersonnel(personnel);
    }

    @Test
    void testGetAllAdmins() {
        assertEquals(10,service.getAll().size());
    }

    @Test
    void testIsSecurityAnswerCorrect() {
        assertEquals(true, service.isSecurityAnswerCorrect(
                    "id1", "firstAnswer1", "secondAnswer1", "thirdAnswer1"));
    }

    @Test
    void testIsValid() {
        assertEquals(personnels.get(1), service.isValid("id1", "password1").get());
    }

}