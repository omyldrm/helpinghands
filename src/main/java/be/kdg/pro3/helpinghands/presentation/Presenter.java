package be.kdg.pro3.helpinghands.presentation;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.service.EventService;
import be.kdg.pro3.helpinghands.service.OrganizationService;
import be.kdg.pro3.helpinghands.service.VolunteerService;

import java.util.Scanner;

public class Presenter {
    private final ConsoleView consoleView;
    private final EventService eventService;
    private final OrganizationService organizationService;
    private final VolunteerService volunteerService;
    private boolean running = true;
    private Scanner sc = new Scanner(System.in);

    public Presenter(ConsoleView consoleView, EventService eventService, OrganizationService organizationService, VolunteerService volunteerService) {
        this.consoleView = consoleView;
        this.eventService = eventService;
        this.organizationService = organizationService;
        this.volunteerService = volunteerService;
    }

    public void start() {
        while (running) {
            consoleView.showMainMenu();
            int answer = sc.nextInt();
            switch (answer){
                case 1 -> consoleView.showEventsMenu();
                case 2 -> consoleView.showVolunteersMenu();
                case 3 -> volunteerService.getAllVolunteers();
                case 4 -> running = false;
            }
        }
    }

    // could do methods for each selections like event workflow and call it in the switches

    private void eventWorkflow(){
        consoleView.showEventsMenu();
        int answer = sc.nextInt();
        while (running) {
            switch (answer) {
                case 1 -> eventService.getEventsByType();
                case 2 -> eventService.getEventsByOrg();
                case 3 -> eventService.getEventsByVolunteer();
                case 4 -> eventService.getEventsByDate();
                case 5 -> eventService.getAllEvents();
                default -> running = false;
            }
        }
    }

    private void volunteerWorkflow(){

    }
}
