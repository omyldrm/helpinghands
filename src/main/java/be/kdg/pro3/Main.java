package be.kdg.pro3;

import be.kdg.pro3.helpinghands.repository.DataFactory;
import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.domain.Volunteer;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static void main() {
        DataFactory.seed();
        boolean running = true;
        while (running) {
            System.out.println(createMainMenu());
            int answer = readInt(1, 4);
            switch (answer) {
                case 1 -> handleEventsMenu();
                case 2 -> handleVolunteersMenu();
                case 3 -> DataFactory.organizations.forEach(System.out::println);
                case 4 -> running = false;
                default -> System.out.println("Choose between 1 and 4");
            }
        }
        System.out.println("Exiting");
    }

    /* need a try and catch method to not paste it everywhere, one for id's which dont have
    any range and one that checks the menu answers
     */
    static int readInt() {
        while (true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Please enter a valid number");
                sc.next();
            }
        }
    }

    // for menu
    static int readInt(int min, int max) {
        while (true) {
            int value = readInt();
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println("Please choose between " + min + " and " + max);
            }
        }
    }

    // full events flow
    static void handleEventsMenu() {
        System.out.println(createSubMenuForEvents());
        int answer = readInt(1, 6);
        switch (answer) {
            case 1 -> handleEventsByType();
            case 2 -> DataFactory.organizations.forEach(org -> {
                System.out.println(org.getName() + ":");
                org.getEvents().forEach(e -> System.out.println("  - " + e.getTitle()));
            });
            case 3 -> {
                System.out.println("Enter volunteer id:");
                int id = readInt();
                DataFactory.events.stream()
                        .filter(e -> e.getVolunteers().stream().anyMatch(v -> v.getId() == id))
                        .forEach(e -> System.out.println(e));
            }
            case 4 -> DataFactory.events.stream()
                    .sorted((a, b) -> a.getEventDate().compareTo(b.getEventDate()))
                    .forEach(System.out::println);
            case 5 -> DataFactory.events.forEach(System.out::println);
            case 6 -> System.out.println("Go back to menu");
            default -> System.out.println("Choose between 1 and 6");
        }
    }

    // events by type method
    static void handleEventsByType() {
        System.out.println(createSubMenuForEventsByType());
        int answer = readInt(1, 8);
        EventCategory category = switch (answer) {
            case 1 -> EventCategory.CLEANUP;
            case 2 -> EventCategory.FUNDRAISER;
            case 3 -> EventCategory.FOOD_DISTRIBUTION;
            case 4 -> EventCategory.EDUCATION;
            case 5 -> EventCategory.ANIMAL_CARE;
            case 6 -> EventCategory.HEALTHCARE;
            case 7 -> EventCategory.CONCERT;
            default -> null;
        };
        DataFactory.events.stream()
                .filter(e -> e.getCategory() == category)
                .forEach(System.out::println);
    }

    // volunteer flow
    static void handleVolunteersMenu() {
        System.out.println(createSubMenuForVolunteers());
        int answer = readInt(1, 4);
        switch (answer) {
            case 1 -> {
                System.out.println("Enter a name:");
                String name = sc.next();
                DataFactory.volunteers.stream()
                        .filter(v -> v.getFirstName().equalsIgnoreCase(name)
                                || v.getLastName().equalsIgnoreCase(name))
                        .forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Enter an id:");
                int id = readInt();
                DataFactory.volunteers.stream()
                        .filter(v -> v.getId() == id)
                        .forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Enter volunteer id:");
                int id = readInt();
                Volunteer found = DataFactory.volunteers.stream()
                        .filter(v -> v.getId() == id)
                        .findFirst().orElse(null);
                DataFactory.events.stream()
                        .filter(e -> e.getVolunteers().contains(found))
                        .forEach(System.out::println);
            }
            case 4 -> DataFactory.volunteers.forEach(System.out::println);
            default -> System.out.println("Choose between 1 and 4");
        }
    }

}