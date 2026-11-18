package be.kdg.pro3.helpinghands.presentation.controller;

import be.kdg.pro3.helpinghands.domain.Volunteer;
import be.kdg.pro3.helpinghands.service.VolunteerService;
import be.kdg.pro3.helpinghands.presentation.web.VolunteerForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/volunteers")
public class VolunteerController {
    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping
    public String showVolunteers(Model model) {
        model.addAttribute("volunteers", volunteerService.getAllVolunteers());
        return "volunteers";
    }

    @GetMapping("/add")
    public String showAddVolunteerForm(Model model) {
        model.addAttribute("volunteerForm", new VolunteerForm());
        return "add-volunteers";
    }

    @PostMapping("/add")
    public String submitAddVolunteer(@ModelAttribute("volunteerForm") VolunteerForm volunteerForm) {
        Volunteer volunteer = new Volunteer(
                volunteerForm.getFirstName(),
                volunteerForm.getLastName(),
                volunteerForm.getEmail(),
                volunteerForm.getBirthDate(),
                volunteerForm.isStudent(),
                volunteerForm.getAvatarUrl(),
                0
        );
        volunteerService.addVolunteer(volunteer);
        return "redirect:/volunteers";
    }
}