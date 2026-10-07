package be.kdg.pro3.helpinghands.presentation;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.domain.Organization;
import be.kdg.pro3.helpinghands.domain.Status;
import be.kdg.pro3.helpinghands.domain.Volunteer;
import be.kdg.pro3.helpinghands.service.EventService;
import be.kdg.pro3.helpinghands.service.OrganizationService;
import be.kdg.pro3.helpinghands.service.VolunteerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@Component
public class Presenter implements CommandLineRunner {
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

    @Override
    public void run(String... args) {
        start();
    }

    public void start() {
        boolean running = true;
        while (running) {
            consoleView.showMainMenu();
            int answer = readInt();

            try {
                switch (answer) {
                    case 1 -> eventWorkflow();
                    case 2 -> volunteerWorkflow();
                    case 3 -> consoleView.showOrganizations(organizationService.getAllOrganizations());
                    case 4 -> addOrganizationWorkflow();
                    case 5 -> running = false;
                    default -> consoleView.showMessage("Invalid choice, choose between 1 and 5.");
                }
            } catch (IllegalArgumentException e) {
                consoleView.showMessage(e.getMessage());
            }
        }
    }

    // could do methods for each selections like event workflow and call it in the switches

    private void eventWorkflow() {
        boolean inMenu = true;
        while (inMenu) {
            consoleView.showEventsMenu();
            int answer = readInt();

            try {
                switch (answer) {
                    case 1 -> {
                        // get events by type
                        EventCategory category = readCategory();
                        if (category != null) {
                            consoleView.showEvents(eventService.getEventsByType(category));
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
                    case 6 -> addEventWorkflow();
                    case 7 -> inMenu = false;
                    default -> consoleView.showMessage("Invalid choice, choose between 1 and 7.");
                }
            } catch (IllegalArgumentException e) {
                consoleView.showMessage(e.getMessage());
            }
        }
    }

    private void volunteerWorkflow() {
        boolean inMenu = true;
        while (inMenu) {
            consoleView.showVolunteersMenu();
            int answer = readInt();

            try {
                switch (answer) {
                    case 1 -> {
                        consoleView.showMessage("Who are you looking for?");
                        String name = sc.nextLine().trim();
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
                    case 5 -> addVolunteerWorkflow();
                    case 6 -> inMenu = false;
                    default -> consoleView.showMessage("Invalid choice, choose between 1 and 6.");
                }
            } catch (IllegalArgumentException e) {
                consoleView.showMessage(e.getMessage());
            }
        }
    }

    private void addEventWorkflow() {
        consoleView.showMessage("Title:");
        String title = sc.nextLine().trim();

        consoleView.showMessage("Date (yyyy-MM-dd):");
        LocalDate date = readDate();

        consoleView.showMessage("Max number of volunteers:");
        int maxVolunteers = readInt();

        EventCategory category = readCategory();
        if (category == null) {
            return;
        }

        Status status = readStatus();

        consoleView.showMessage("Location:");
        String location = sc.nextLine().trim();

        consoleView.showOrganizations(organizationService.getAllOrganizations());
        consoleView.showMessage("ID of the organization:");
        long organizationId = readLong();

        Event event = eventService.createEvent(title, date, maxVolunteers, category, status, location, organizationId);
        consoleView.showMessage("Event added: " + event);
    }

    private void addVolunteerWorkflow() {
        consoleView.showMessage("First name:");
        String firstName = sc.nextLine().trim();

        consoleView.showMessage("Last name:");
        String lastName = sc.nextLine().trim();

        consoleView.showMessage("Email:");
        String email = sc.nextLine().trim();

        consoleView.showMessage("Birth date (yyyy-MM-dd):");
        LocalDate birthDate = readDate();

        consoleView.showMessage("Student? (y/n):");
        boolean isStudent = sc.nextLine().trim().equalsIgnoreCase("y");

        Volunteer volunteer = volunteerService.createVolunteer(firstName, lastName, email, birthDate, isStudent);
        consoleView.showMessage("Volunteer added: " + volunteer);
    }

    private void addOrganizationWorkflow() {
        consoleView.showMessage("Name:");
        String name = sc.nextLine().trim();

        consoleView.showMessage("Founded date (yyyy-MM-dd):");
        LocalDate foundedDate = readDate();

        Organization organization = organizationService.createOrganization(name, foundedDate);
        consoleView.showMessage("Organization added: " + organization);
    }

    private EventCategory readCategory() {
        while (true) {
            consoleView.showEventTypeMenu();
            int choice = readInt();
            switch (choice) {
                case 1 -> { return EventCategory.CLEANUP; }
                case 2 -> { return EventCategory.FUNDRAISER; }
                case 3 -> { return EventCategory.FOOD_DISTRIBUTION; }
                case 4 -> { return EventCategory.EDUCATION; }
                case 5 -> { return EventCategory.ANIMAL_CARE; }
                case 6 -> { return EventCategory.HEALTHCARE; }
                case 7 -> { return EventCategory.CONCERT; }
                case 8 -> { return null; }
                default -> consoleView.showMessage("Invalid choice, choose between 1 and 8.");
            }
        }
    }

    private Status readStatus() {
        while (true) {
            consoleView.showStatusMenu();
            int choice = readInt();
            switch (choice) {
                case 1 -> { return Status.PLANNED; }
                case 2 -> { return Status.ONGOING; }
                case 3 -> { return Status.COMPLETED; }
                case 4 -> { return Status.CANCELLED; }
                default -> consoleView.showMessage("Invalid choice, choose between 1 and 4.");
            }
        }
    }

    private int readInt() {
        while (!sc.hasNextInt()) {
            sc.nextLine();
            consoleView.showMessage("Please enter a whole number:");
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

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
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                consoleView.showMessage("Invalid date, use yyyy-MM-dd (e.g. 2026-10-07):");
            }
        }
    }
}