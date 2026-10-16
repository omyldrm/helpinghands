package be.kdg.pro3.helpinghands.controller;

import be.kdg.pro3.helpinghands.service.EventService;
import be.kdg.pro3.helpinghands.service.OrganizationService;
import be.kdg.pro3.helpinghands.web.EventForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public String showAddEventForm(Model model){
        model.addAttribute("eventForm", new EventForm());
        model.addAttribute("organizations", organizationService.getAllOrganizations());
        return "add-events";
    }


}
