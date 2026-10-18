package be.kdg.pro3.helpinghands.controller;

import be.kdg.pro3.helpinghands.domain.Organization;
import be.kdg.pro3.helpinghands.service.OrganizationService;
import be.kdg.pro3.helpinghands.web.OrganizationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public String showAllOrganizations(Model model){
        model.addAttribute("organizations", organizationService.getAllOrganizations());
        return "organizations";
    }

    @GetMapping
    public String showOrganizationForm(Model model){
        model.addAttribute("organizationForm", new OrganizationForm());
        return "add-organizations";
    }

    @PostMapping("/add")
    public String submitOrganizationForm(@ModelAttribute("organizationForm") OrganizationForm organizationForm){
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
