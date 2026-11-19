package be.kdg.pro3.helpinghands.presentation.controller;

import be.kdg.pro3.helpinghands.domain.Volunteer;
import be.kdg.pro3.helpinghands.presentation.web.UserSessionHistory;
import be.kdg.pro3.helpinghands.service.VolunteerService;
import be.kdg.pro3.helpinghands.presentation.web.VolunteerForm;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/volunteers")
public class VolunteerController {
    private static final Logger logger = LoggerFactory.getLogger(VolunteerController.class);

    private final VolunteerService volunteerService;
    private final UserSessionHistory sessionHistory;

    public VolunteerController(VolunteerService volunteerService, UserSessionHistory sessionHistory) {
        this.volunteerService = volunteerService;
        this.sessionHistory = sessionHistory;
    }

    @GetMapping
    public String showVolunteers(Model model) {
        sessionHistory.addVisit("Volunteers Overview");
        model.addAttribute("volunteers", volunteerService.getAllVolunteers());
        return "volunteers";
    }

    @GetMapping("/add")
    public String showAddVolunteerForm(Model model) {
        sessionHistory.addVisit("Add Volunteer");
        model.addAttribute("volunteerForm", new VolunteerForm());
        return "add-volunteers";
    }

    @PostMapping("/add")
    public String submitAddVolunteer(@Valid @ModelAttribute("volunteerForm") VolunteerForm volunteerForm,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.warn("Validation error on volunteer form: {}", error));
            return "add-volunteers";
        }

        logger.info("Adding volunteer: {} {}", volunteerForm.getFirstName(), volunteerForm.getLastName());
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
        logger.info("Volunteer '{} {}' added successfully", volunteerForm.getFirstName(), volunteerForm.getLastName());
        return "redirect:/volunteers";
    }
}