package com.cognizant.fraudmanagementsystem.controller;

import java.util.Optional;
import com.cognizant.fraudmanagementsystem.model.FraudAnalysisPersonnel;
import com.cognizant.fraudmanagementsystem.services.FraudAnalysisPersonnelService;
import com.cognizant.fraudmanagementsystem.util.CurrentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FraudAnalysisPersonnelController {
    
    @Autowired
    private FraudAnalysisPersonnelService fraudAnalysisPersonnelService;

    @GetMapping(value = "/register/fraud-analysis-personnel")
    public String showRegistrationPage(ModelMap model) {
        model.addAttribute("user", new FraudAnalysisPersonnel());
        return "register/fraud-analysis-personnel";
    }

    @PostMapping(value = "/register/fraud-analysis-personnel")
	public String register(
        ModelMap model, 
        FraudAnalysisPersonnel fraudAnalysisPersonnel
    ) {
		if (fraudAnalysisPersonnelService.addFraudAnalysisPersonnel(fraudAnalysisPersonnel)) {
            return "redirect:/login/fraud-analysis-personnel";
        } else {
            model.put("error", "Something went wrong while adding user. Try again.");
            return "redirect:/register/fraud-analysis-personnel";
        }
	}

    @GetMapping(value = "/login/fraud-analysis-personnel")
    public String showLoginPage(ModelMap model) {
        return "login/fraud-analysis-personnel";
    }

    @PostMapping(value = "/login/fraud-analysis-personnel") 
    public String login(
        ModelMap model, 
        @RequestParam String id, 
        @RequestParam String password
    ){
		Optional<FraudAnalysisPersonnel> fraudAnalysisPersonnel = fraudAnalysisPersonnelService.isValid(id,password);
        
		if(fraudAnalysisPersonnel.isEmpty()) {
            System.out.println("Empty");
			model.put("error","Invalid FraudAnalysisPersonnel Credentials");
		    return "login/fraud-analysis-personnel";
		}
        
        if(fraudAnalysisPersonnel.get().getIsAuthorized() == 0) {
            System.out.println("is authorized = 0");
            model.put("error", "Your Registration Request is Rejected by Admin");
            return "login/fraud-analysis-personnel";
        } 
        
        if(fraudAnalysisPersonnel.get().getIsAuthorized() == 1) {
            System.out.println("is authorized = 1");
            model.put("error","Your Registration is still pending");
            return "login/fraud-analysis-personnel";
        }
        
        model.addAttribute("user", fraudAnalysisPersonnel.get());
        System.out.println((FraudAnalysisPersonnel)model.getAttribute("user"));
        model.put("id", fraudAnalysisPersonnel.get().getId());

        CurrentUser.id = id;

        return "redirect:/fraud-analyzer-dashboard";    
    } 

    @GetMapping(value = "/submitted/fraud-analysis-personnel")
    public String submitted() {
        return "common/submitted";
    }

    @GetMapping(value = "/fraud-analyzer-dashboard")
    public String showFraudAnalyzerPage() {
        return "dashboard/fraud-analyzer-dashboard";
    }

    @GetMapping(value = "/fraud-analysis-personnel-forgot-password")
    public String showForgotPasswordPage() {
        return "util/fraud-analysis-personnel-forgot-password";
    }

    @PostMapping(value = "/fraud-analysis-personnel-forgot-password")
    public String forgotPassword(
        String id,
        String firstAnswer,
        String secondAnswer,
        String thirdAnswer
    ) {
        if (fraudAnalysisPersonnelService.isSecurityAnswerCorrect(
            id, 
            firstAnswer, 
            secondAnswer, 
            thirdAnswer)
        ) {
            CurrentUser.id = id;
            return "redirect:/reset-fraud-analysis-personnel-password";
        } else {
            return "redirect:/fraud-analysis-personnel-forgot-password";
        }
    }

    @GetMapping(value = "/reset-fraud-analysis-personnel-password")
    public String showResetPasswordPage() {
        return "util/reset-password";
    }

    @PostMapping(value = "/reset-fraud-analysis-personnel-password")
    public String resetPassword(String newPassword, String confirmNewPassword) {
        if (newPassword.equals(confirmNewPassword)) {
            fraudAnalysisPersonnelService.updatePassword(CurrentUser.id, newPassword);
            return "redirect:/login/fraud-analysis-personnel";
        } else {
            return "util/reset-password";
        }
    }

}
