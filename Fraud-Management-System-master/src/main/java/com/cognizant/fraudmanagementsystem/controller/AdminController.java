package com.cognizant.fraudmanagementsystem.controller;

import java.util.Optional;
import com.cognizant.fraudmanagementsystem.model.Admin;
import com.cognizant.fraudmanagementsystem.model.FraudAnalysisPersonnel;
import com.cognizant.fraudmanagementsystem.services.AdminService;
import com.cognizant.fraudmanagementsystem.services.CardService;
import com.cognizant.fraudmanagementsystem.services.ClaimService;
import com.cognizant.fraudmanagementsystem.services.FraudAnalysisPersonnelService;
import com.cognizant.fraudmanagementsystem.services.TransactionService;
import com.cognizant.fraudmanagementsystem.util.CurrentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @Autowired 
    private FraudAnalysisPersonnelService fraudAnalysisPersonnelService;

    @Autowired
    private CardService cardService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ClaimService claimService;

    @GetMapping(value = "/register/admin")
    public String showRegistrationPage(ModelMap model) {
        model.addAttribute("user", new Admin());
        return "register/admin";
    }

    @PostMapping(value = "/register/admin")
	public String register(
        ModelMap model, 
        Admin admin
    ) {
		if (adminService.addAdmin(admin)) {
            model.put("id", admin.getId());
            return "redirect:/login/admin";
        } else {
            model.put("error", "Something went wrong while adding user. Try again.");
            return "redirect:/register/admin";
        }
	}

    @GetMapping(value = "/submitted/admin")
    public String submitted() {
        return "common/submitted";
    }

    @GetMapping(value = "/login/admin")
    public String showLoginPage(ModelMap model) {
        return "login/admin";
    }

    @PostMapping(value = "/login/admin") 
    public String login(
        ModelMap model, 
        @RequestParam String id, 
        @RequestParam String password
    ){
		Optional<Admin> admin = adminService.isValid(id,password);
        
		if(admin.isEmpty()) {
			model.put("error","Invalid Admin Credentials");
		    return "login/admin";
		}
        CurrentUser.type = "Admin";
        model.put("user", admin);
        return "redirect:/admin-dashboard";    
    } 

    @GetMapping(value = "/admin-dashboard")
    public String showAdminDashboardPage() {
        return "dashboard/admin-dashboard";
    }

    @GetMapping(value = "/manage-users")
    public String showManageUsersPage(ModelMap model) {
        model.addAttribute("users",fraudAnalysisPersonnelService.getAll());
        return "fraud/manage-users";
    }

    @GetMapping(value = "/add-user")
    public String showAddUserPage(ModelMap model) {
        model.addAttribute("user", new FraudAnalysisPersonnel());
        return "register/fraud-analysis-personnel";
    }

    @PostMapping(value = "/add-user")
	public String addUser(
        ModelMap model, 
        FraudAnalysisPersonnel fraudAnalysisPersonnel
    ) {
		if (fraudAnalysisPersonnelService.addFraudAnalysisPersonnel(fraudAnalysisPersonnel)) {
            return "redirect:/manage-users";
        } else {
            model.put("error", "Something went wrong while adding user. Try again.");
            return "redirect:/manage-users";
        }
	}

    @PostMapping(value = "/accept-user")
    public String acceptUser(ModelMap model, String id) {
        fraudAnalysisPersonnelService.updateAuthorization(id, 2);
        model.addAttribute("users",fraudAnalysisPersonnelService.getAll());
        return "fraud/manage-users";
    }

    
    @PostMapping(value = "/reject-user")
    public String rejectUser(ModelMap model, String id) {
        fraudAnalysisPersonnelService.updateAuthorization(id, 0);
        model.addAttribute("users",fraudAnalysisPersonnelService.getAll());
        return "fraud/manage-users";
    }

    @GetMapping(value = "/card-admin")
    public String showCardPage(ModelMap model) {
        model.addAttribute("type","Admin");
        model.addAttribute("cards",cardService.getAllCards());
        return "fraud/cards";
    }

    @GetMapping(value = "/claim-admin")
    public String showClaimPage(ModelMap model) {
        model.addAttribute("type","Admin");
        model.addAttribute("claims",claimService.getAllClaims());
        return "fraud/claims";
    }

    @GetMapping(value = "/transaction-admin")
    public String showTransactionPage(ModelMap model) {
        model.addAttribute("type","Admin");
        model.addAttribute("transactions",transactionService.getAllTransactions());
        return "fraud/transactions";
    }

    @PostMapping(value = "/card-delete-admin")
	public String deleteCard(ModelMap model, String id) {
        System.out.println("Card is being deleted...");
        model.addAttribute("type","Admin");
		cardService.delete(cardService.getCardById(Integer.valueOf(id)));
		return "redirect:/card-admin";
	}

    @PostMapping(value = "/claim-delete-admin")
	public String deleteClaim(ModelMap model, String id) {
        System.out.println("Claim is being deleted...");
        model.addAttribute("type","Admin");
		claimService.delete(claimService.getClaimById(Integer.valueOf(id)));
		return "redirect:/claim-admin";
	}

    @PostMapping(value = "/transaction-delete-admin")
	public String deleteTransaction(ModelMap model, String id) {
        System.out.println("Transaction is being deleted...");
        model.addAttribute("type","Admin");
		transactionService.delete(transactionService.getTransactionById(Integer.valueOf(id)));
		return "redirect:/transaction-admin";
	}

    @GetMapping(value = "/admin-forgot-password")
    public String showForgotPasswordPage() {
        return "util/admin-forgot-password";
    }

    @PostMapping(value = "/admin-forgot-password")
    public String forgotPassword(
        String id,
        String firstAnswer,
        String secondAnswer,
        String thirdAnswer
    ) {
        if (adminService.isSecurityAnswerCorrect(
            id, 
            firstAnswer, 
            secondAnswer, 
            thirdAnswer)
        ) {
            CurrentUser.id = id;
            return "redirect:/reset-admin-password";
        } else {
            return "redirect:/admin-forgot-password";
        }
    }

    @GetMapping(value = "reset-admin-password")
    public String showResetAdminPasswordPage() {
        return "util/reset-password";
    }

    @PostMapping(value = "/reset-admin-password")
    public String resetAdminPassword(String newPassword, String confirmNewPassword) {
        if (newPassword.equals(confirmNewPassword)) {
            adminService.updatePassword(CurrentUser.id, newPassword);
            return "redirect:/login/admin";
        } else {
            return "util/reset-password";
        }
    }

    @GetMapping(value = "logout")
    public String logout() {
        CurrentUser.id = "";
        return "redirect:/";
    }

}
