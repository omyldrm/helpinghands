package be.kdg.pro3.helpinghands.presentation;

import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.service.EventService;
import be.kdg.pro3.helpinghands.service.OrganizationService;
import be.kdg.pro3.helpinghands.service.VolunteerService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@Component
public class Presenter {
    private final ConsoleView consoleView;
    private final EventService eventService;
    private final OrganizationService organizationService;
    private final VolunteerService volunteerService;
    private final Scanner sc = new Scanner(System.in);

    public Presenter(ConsoleView consoleView, EventService eventService,
                     OrganizationService organizationService, VolunteerService volunteerService) {
        this.consoleView = consoleView;
        this.eventService = eventService;
        this.organizationService = organizationService;
        this.volunteerService = volunteerService;
    }

    public void start() {
        boolean running = true;
        while (running) {
            consoleView.showMainMenu();
            int answer = readInt();

            switch (answer) {
                case 1 -> eventWorkflow();
                case 2 -> volunteerWorkflow();
                case 3 -> consoleView.showOrganizations(organizationService.getAllOrganizations());
                case 4 -> running = false;
                default -> consoleView.showMessage("Invalid choice, choose between 1 and 4.");
            }
        }
    }

    // could do methods for each selections like event workflow and call it in the switches

    private void eventWorkflow() {
        boolean inMenu = true;
        while (inMenu) {
            consoleView.showEventsMenu();
            int answer = readInt();

            switch (answer) {
                case 1 -> {
                    // get events by type
                    consoleView.showEventTypeMenu();
                    int choice = readInt();

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
                        consoleView.showEvents(eventService.getEventsByType(category));
                    } else if (choice != 8) {
                        consoleView.showMessage("Invalid choice, choose between 1 and 8.");
                    }
                }
                case 2 -> {
                    // get events per org
                    consoleView.showOrganizations(organizationService.getAllOrganizations());
                    consoleView.showMessage("From which organization do you want to see the events for? Which ID?");
                    long id = readLong();
                    consoleView.showEvents(eventService.getEventsByOrg(id));
                }
                case 3 -> {
                    // get events by organizations
                    consoleView.showMessage("What's the name of the volunteer?");
                    String name = sc.nextLine().trim();
                    consoleView.showEvents(eventService.getEventsByVolunteer(name));
                }
                case 4 -> {
                    consoleView.showMessage("Enter a date (yyyy-MM-dd):");
                    LocalDate date = readDate();
                    consoleView.showEvents(eventService.getEventsByDate(date));
                }
                case 5 -> consoleView.showEvents(eventService.getAllEvents());
                case 6 -> inMenu = false;
                default -> consoleView.showMessage("Invalid choice, choose between 1 and 6.");
            }
        }
    }

    private void volunteerWorkflow() {
        boolean inMenu = true;
        while (inMenu) {
            consoleView.showVolunteersMenu();
            int answer = readInt();
            // in volunteer menu

            switch (answer) {
                case 1 -> {
                    consoleView.showMessage("Who are you looking for?");
                    String name = sc.nextLine().toLowerCase().trim();
                    consoleView.showVolunteers(volunteerService.getVolunteersByName(name));
                }
                case 2 -> {
                    consoleView.showMessage("Give the ID:");
                    long id = readLong();
                    consoleView.showVolunteers(volunteerService.getVolunteersById(id));
                }
                case 3 -> {
                    consoleView.showEvents(eventService.getAllEvents());
                    consoleView.showMessage("What is the ID of the event?");
                    long id = readLong();
                    consoleView.showVolunteers(volunteerService.getVolunteersByEvent(id));
                }
                case 4 -> consoleView.showVolunteers(volunteerService.getAllVolunteers());
                case 5 -> inMenu = false;
                default -> consoleView.showMessage("Invalid choice, choose between 1 and 5.");
            }
        }
    }

    // checks the input format of the int
    private int readInt() {
        while (!sc.hasNextInt()) {
            sc.nextLine();
            consoleView.showMessage("Please enter a whole number:");
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    // same as readint but long
    private long readLong() {
        while (!sc.hasNextLong()) {
            sc.nextLine();
            consoleView.showMessage("Please enter a valid ID (a number):");
        }
        long value = sc.nextLong();
        sc.nextLine();
        return value;
    }

    private LocalDate readDate() {
        while (true) {
            String input = sc.nextLine().trim();
            try {
                // need something to turn the String to a localdate
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                // exception to check if its a valid date
                consoleView.showMessage("Invalid date, use yyyy-MM-dd (e.g. 2026-10-07):");
            }
        }
    }
}