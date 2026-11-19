package be.kdg.pro3.helpinghands.presentation.controller;

import be.kdg.pro3.helpinghands.domain.Organization;
import be.kdg.pro3.helpinghands.presentation.web.UserSessionHistory;
import be.kdg.pro3.helpinghands.service.OrganizationService;
import be.kdg.pro3.helpinghands.presentation.web.OrganizationForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;
    private final UserSessionHistory sessionHistory;

    public OrganizationController(OrganizationService organizationService, UserSessionHistory sessionHistory) {
        this.organizationService = organizationService;
        this.sessionHistory = sessionHistory;
    }

    @GetMapping
    public String showAllOrganizations(Model model){
        sessionHistory.addVisit("Organizations Overview");
        model.addAttribute("organizations", organizationService.getAllOrganizations());
        return "organizations";
    }

    @GetMapping("/add")
    public String showOrganizationForm(Model model){
        sessionHistory.addVisit("Add Organization");
        model.addAttribute("organizationForm", new OrganizationForm());
        return "add-organizations";
    }

    @PostMapping("/add")
    public String submitOrganizationForm(@Valid @ModelAttribute("organizationForm") OrganizationForm organizationForm,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "add-organizations";
        }

        Organization newOrganization = new Organization(
                organizationForm.getName(),
                organizationForm.getFoundedDate(),
                organizationForm.getAverageRating(),
                organizationForm.isVerified(),
                organizationForm.getLogoUrl(),
                null
        );
        organizationService.addOrganization(newOrganization);
        return "redirect:/organizations";
    }
}