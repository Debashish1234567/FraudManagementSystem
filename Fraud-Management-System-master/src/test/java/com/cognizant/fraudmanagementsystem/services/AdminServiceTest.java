package com.cognizant.fraudmanagementsystem.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.fraudmanagementsystem.model.Admin;
import com.cognizant.fraudmanagementsystem.repositories.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AdminServiceTest {

    @Autowired
    private AdminService service;

    @MockBean
    private AdminRepository repository;

    @Mock
    private List<Admin> admins;

    @BeforeEach
    public void setup() {
        admins = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Admin admin = new Admin();
			admin.setId("id" + i);
			admin.setPassword("password" + i);
            admin.setFirstAnswer("firstAnswer" + i);
            admin.setSecondAnswer("secondAnswer" + i);
            admin.setThirdAnswer("thirdAnswer" + i);
			admins.add(admin);
		}
        when(repository.getAllAdmins()).thenReturn(admins);
    }

    @Test
    void testAddAdmin() {
        Admin admin = new Admin();
        admin.setId("id11");
        admin.setPassword("password11");
        doAnswer(answer -> { 
            admins.add(admin);
            assertEquals(true, service.isValid("id11", "password11"));
            return null;
        }).when(repository).addAdmin(admin);
    }

    @Test
    void testGetAllAdmins() {
        assertEquals(10,service.getAllAdmins().size());
    }

    @Test
    void testIsSecurityAnswerCorrect() {
        assertEquals(true, service.isSecurityAnswerCorrect(
                    "id1", "firstAnswer1", "secondAnswer1", "thirdAnswer1"));
    }

    @Test
    void testIsValid() {
        assertEquals(admins.get(1), service.isValid("id1", "password1").get());
    }

}
