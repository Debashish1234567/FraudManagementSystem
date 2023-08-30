package com.cognizant.fraudmanagementsystem.services;

import java.util.List;
import java.util.Optional;
import com.cognizant.fraudmanagementsystem.model.FraudAnalysisPersonnel;
import com.cognizant.fraudmanagementsystem.repositories.FraudAnalysisPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudAnalysisPersonnelService {
    
    private FraudAnalysisPersonnelRepository fraudAnalysisPersonnelRepository;

    @Autowired
    public FraudAnalysisPersonnelService(FraudAnalysisPersonnelRepository fraudAnalysisPersonnelRepository) {
        this.fraudAnalysisPersonnelRepository = fraudAnalysisPersonnelRepository;
    }

    public List<FraudAnalysisPersonnel> getAll() {
        return fraudAnalysisPersonnelRepository.getAllFraudAnalysisPersonnels();
    }

    public Optional<FraudAnalysisPersonnel> isValid(String userId, String password) {
        return getAll().stream()
                    .filter(fraudAnalysisPersonnel-> 
                        fraudAnalysisPersonnel.getId().equals(userId) && 
                        fraudAnalysisPersonnel.getPassword().equals(password)
                    ).findAny();
    }

    public FraudAnalysisPersonnel getFraudAnalysisPersonnelById(String id) {
        return fraudAnalysisPersonnelRepository.getFraudAnalysisPersonnelById(id);
    }

    public boolean addFraudAnalysisPersonnel(FraudAnalysisPersonnel fraudAnalysisPersonnel) {
        try {
            fraudAnalysisPersonnelRepository.addFraudAnalysisPersonnel(fraudAnalysisPersonnel);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void deleteFraudAnalysisPersonnel(String id) {
        fraudAnalysisPersonnelRepository.delete(id);
    }

    public void updateAuthorization(String id, int newAuthorizationValue) {
        fraudAnalysisPersonnelRepository.updateAuthorization(id, newAuthorizationValue);
    }

    public boolean isSecurityAnswerCorrect(
        String id,
        String firstAnswer,
        String secondAnswer,
        String thirdAnswer
    ) {
        return getAll().stream()
            .filter(admin ->
                admin.getId().equals(id) &&
                admin.getFirstAnswer().equals(firstAnswer) &&
                admin.getSecondAnswer().equals(secondAnswer) &&
                admin.getThirdAnswer().equals(thirdAnswer)
            ).findAny().isPresent();
    }

    public void updatePassword(String id, String newPassword) {
        fraudAnalysisPersonnelRepository.updatePassword(id, newPassword);
    }
}
