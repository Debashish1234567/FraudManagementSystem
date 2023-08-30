package com.cognizant.fraudmanagementsystem.controller;

import com.cognizant.fraudmanagementsystem.model.Claim;
import com.cognizant.fraudmanagementsystem.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClaimController {
    
    @Autowired
    private ClaimService claimService;

    @GetMapping(value = "/claim")
    public String showClaimPage(ModelMap model) {
        model.addAttribute("claims",claimService.getAllClaims());
        return "fraud/claims";
    }

    @GetMapping(value = "/add-claim-fraud")
    public String showAddClaimFraudPage(ModelMap model) {
        model.addAttribute("claim", new Claim());
        return "fraud/add-claim";
    }

    @PostMapping(value = "/add-claim-fraud")
    public String addClaimFraud(
        ModelMap model,
        Claim claim
    ) {
        if (claimService.addClaim(claim)) {
            return "redirect:/claim";
        } else {
            model.put("error", "Coundn't add claim");
            return "redirect:/claim";
        }
    }

    @PostMapping(value = "/claim-delete")
	public String deleteClaim(String id) {
        System.out.println("Claim is being deleted...");
		Claim claim = claimService.getClaimById(Integer.valueOf(id));
		claimService.delete(claim);
		return "redirect:/claim";
	}

    @PostMapping(value = "/claim-search")
    public String claimSearch(ModelMap model, String query, String type) {
        model.addAttribute("claims",claimService.searchClaims(query, type));
        return "fraud/claims";
    }

}
