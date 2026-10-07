package be.kdg.pro3.helpinghands.presentation;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.service.EventService;
import be.kdg.pro3.helpinghands.service.OrganizationService;
import be.kdg.pro3.helpinghands.service.VolunteerService;

import java.time.LocalDate;
import java.util.List;
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
                case 1 -> eventWorkflow();
                case 2 -> volunteerWorkflow();
                case 3 -> organizationService.getAllOrganizations();
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
                case 1: {
                    // get events by type
                    consoleView.showEventTypeMenu();
                    int choice = sc.nextInt();

                    EventCategory category = switch (choice) {
                        case 1 -> EventCategory.CLEANUP;
                        case 2 -> EventCategory.FUNDRAISER;
                        case 3 -> EventCategory.FOOD_DISTRIBUTION;
                        case 4 -> EventCategory.EDUCATION;
                        case 5 -> EventCategory.ANIMAL_CARE;
                        case 6 -> EventCategory.HEALTHCARE;
                        case 7 -> EventCategory.CONCERT;
                        default -> null; // back or invalid

                    };

                    if (category != null) {
                        List<Event> events = eventService.getEventsByType(category);
                    }
                }
                case 2: {
                    // get events per org
                    organizationService.getAllOrganizations();
                    System.out.println("From which organization do you want to see the events for? Which ID? ");
                    Long id = sc.nextLong();
                    eventService.getEventsByOrg(id);
                }
                case 3: {
                    // get events by organizations
                    System.out.println("What's the name of the volunteer?");
                    String choice = sc.nextLine();
                    eventService.getEventsByVolunteer(choice);
                }
                case 4: {
                    System.out.println("Enter a date (yyyy-MM-dd):");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    eventService.getEventsByDate(date);
                }
                case 5: {
                    eventService.getAllEvents();
                }
                default: {
                    running = false;
                }
            }
        }
    }

    private void volunteerWorkflow(){
        consoleView.showVolunteersMenu();
        int answer = sc.nextInt();
        while (running) {
            switch (answer) {
                case 1: {
                    System.out.println("Who are you looking for? ");
                    String name = sc.nextLine().toLowerCase().trim();
                    volunteerService.getVolunteersByName(name);
                }
                case 2: {
                    System.out.println("Give the ID: ");
                    Long id = sc.nextLong();
                    volunteerService.getVolunteersById(id);
                }
                case 3: {
                    eventService.getAllEvents();
                    System.out.println("What is the ID of the event?");
                    Long id = sc.nextLong();
                    volunteerService.getVolunteersByEvent(id);
                }
                case 4: {
                    volunteerService.getAllVolunteers();
                }
                default: {
                    running = false;
                }
            }
        }
    }

}
