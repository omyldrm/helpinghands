package be.kdg.pro3.helpinghands.presentation.controller;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.Organization;
import be.kdg.pro3.helpinghands.service.EventService;
import be.kdg.pro3.helpinghands.service.OrganizationService;
import be.kdg.pro3.helpinghands.presentation.web.EventForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final OrganizationService organizationService;

    public EventController(EventService eventService, OrganizationService organizationService) {
        this.eventService = eventService;
        this.organizationService = organizationService;
    }

    // get mapping , calls services , puts data in model and returns html file name
    @GetMapping
    public String showEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events"; // loads src/main/resources/templates/events.html
    }

    @GetMapping("/add")
    public String showAddEventForm(Model model){
        model.addAttribute("eventForm", new EventForm());
        model.addAttribute("organizations", organizationService.getAllOrganizations());
        return "add-events";
    }

    @PostMapping("/add")
    public String submitAddEvent(@Valid @ModelAttribute("eventForm") EventForm eventForm,
                                 BindingResult bindingResult, // holds the validation errors, must come right after the form
                                 Model model) {
        if (bindingResult.hasErrors()) {
            // reload the dropdown and show the form again with the error messages
            model.addAttribute("organizations", organizationService.getAllOrganizations());
            return "add-events";
        }

        Organization organization = organizationService.getOrganizationById(eventForm.getOrganizationId());
        Event newEvent = new Event(eventForm.getTitle(),
                eventForm.getEventDate(),
                eventForm.getMaxVolunteers(),
                eventForm.getCategory(),
                eventForm.getStatus(),
                eventForm.getBannerUrl(),
                null,
                eventForm.getLocation());
        eventService.addEvent(newEvent);
        return "redirect:/events";
    }
}