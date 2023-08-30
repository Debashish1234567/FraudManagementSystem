package com.cognizant.fraudmanagementsystem.services;

import java.util.List;
import java.util.Optional;
import com.cognizant.fraudmanagementsystem.model.Admin;
import com.cognizant.fraudmanagementsystem.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    
    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    public Optional<Admin> isValid(String userId, String password) {
        return getAllAdmins().stream()
                    .filter(admin-> 
                        admin.getId().equals(userId) && 
                        admin.getPassword().equals(password)
                    ).findAny();
    }

    public boolean addAdmin(Admin admin) {
        try {
            adminRepository.addAdmin(admin);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isSecurityAnswerCorrect(
        String id,
        String firstAnswer,
        String secondAnswer,
        String thirdAnswer
    ) {
        return getAllAdmins().stream()
            .filter(admin ->
                admin.getId().equals(id) &&
                admin.getFirstAnswer().equals(firstAnswer) &&
                admin.getSecondAnswer().equals(secondAnswer) &&
                admin.getThirdAnswer().equals(thirdAnswer)
            ).findAny().isPresent();
    }

    public void updatePassword(String id, String newPassword) {
        adminRepository.updatePassword(id, newPassword);
    }
}
