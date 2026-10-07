package be.kdg.pro3.helpinghands.presentation;

import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.service.EventService;
import be.kdg.pro3.helpinghands.service.OrganizationService;
import be.kdg.pro3.helpinghands.service.VolunteerService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
            int answer = sc.nextInt();
            sc.nextLine(); // consume leftover Enter

            switch (answer) {
                case 1 -> eventWorkflow();
                case 2 -> volunteerWorkflow();
                case 3 -> consoleView.showOrganizations(organizationService.getAllOrganizations());
                case 4 -> running = false;
                default -> consoleView.showMessage("Invalid choice, choose between 1 and 4.");
            }
        }
    }

    private void eventWorkflow() {
        boolean inMenu = true;
        while (inMenu) {
            consoleView.showEventsMenu();
            int answer = sc.nextInt();
            sc.nextLine();

            switch (answer) {
                case 1 -> {
                    consoleView.showEventTypeMenu();
                    int choice = sc.nextInt();
                    sc.nextLine();

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
                    }
                }
                case 2 -> {
                    consoleView.showOrganizations(organizationService.getAllOrganizations());
                    consoleView.showMessage("Which organization ID do you want to see the events for?");
                    long id = sc.nextLong();
                    sc.nextLine();
                    consoleView.showEvents(eventService.getEventsByOrg(id));
                }
                case 3 -> {
                    consoleView.showMessage("What's the name of the volunteer?");
                    String name = sc.nextLine();
                    consoleView.showEvents(eventService.getEventsByVolunteer(name));
                }
                case 4 -> {
                    consoleView.showMessage("Enter a date (yyyy-MM-dd):");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    consoleView.showEvents(eventService.getEventsByDate(date));
                }
                case 5 -> consoleView.showEvents(eventService.getAllEvents());
                case 6 -> inMenu = false; // back to main menu
                default -> consoleView.showMessage("Invalid choice, choose between 1 and 6.");
            }
        }
    }

    private void volunteerWorkflow() {
        boolean inMenu = true;
        while (inMenu) {
            consoleView.showVolunteersMenu();
            int answer = sc.nextInt();
            sc.nextLine();

            switch (answer) {
                case 1 -> {
                    consoleView.showMessage("Who are you looking for?");
                    String name = sc.nextLine().toLowerCase().trim();
                    consoleView.showVolunteers(volunteerService.getVolunteersByName(name));
                }
                case 2 -> {
                    consoleView.showMessage("Give the ID:");
                    long id = sc.nextLong();
                    sc.nextLine();
                    consoleView.showVolunteers(volunteerService.getVolunteersById(id));
                }
                case 3 -> {
                    consoleView.showEvents(eventService.getAllEvents());
                    consoleView.showMessage("What is the ID of the event?");
                    long id = sc.nextLong();
                    sc.nextLine();
                    consoleView.showVolunteers(volunteerService.getVolunteersByEvent(id));
                }
                case 4 -> consoleView.showVolunteers(volunteerService.getAllVolunteers());
                case 5 -> inMenu = false; // back to main menu
                default -> consoleView.showMessage("Invalid choice, choose between 1 and 5.");
            }
        }
    }
}