package be.kdg.pro3;

import be.kdg.pro3.model.DataFactory;
import be.kdg.pro3.model.entities.EventCategory;
import be.kdg.pro3.model.entities.Volunteer;

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
                case 3 -> DataFactory.organizations.forEach(org -> System.out.println(org));
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
                    .forEach(e -> System.out.println(e));
            case 5 -> DataFactory.events.forEach(e -> System.out.println(e));
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
                .forEach(e -> System.out.println(e));
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
                        .forEach(v -> System.out.println(v));
            }
            case 2 -> {
                System.out.println("Enter an id:");
                int id = readInt();
                DataFactory.volunteers.stream()
                        .filter(v -> v.getId() == id)
                        .forEach(v -> System.out.println(v));
            }
            case 3 -> {
                System.out.println("Enter volunteer id:");
                int id = readInt();
                Volunteer found = DataFactory.volunteers.stream()
                        .filter(v -> v.getId() == id)
                        .findFirst().orElse(null);
                DataFactory.events.stream()
                        .filter(e -> e.getVolunteers().contains(found))
                        .forEach(e -> System.out.println(e));
            }
            case 4 -> DataFactory.volunteers.forEach(v -> System.out.println(v));
            default -> System.out.println("Choose between 1 and 4");
        }
    }

    // menu strings
    public static String createMainMenu() {
        return "What is your choice? \n" +
                "1. Get events \n" +
                "2. Get volunteers \n" +
                "3. Get organizations \n" +
                "4. Exit \n" +
                "Choose between 1 and 4";
    }

    public static String createSubMenuForEvents() {
        return "What is your choice? \n" +
                "1. Get events by type \n" +
                "2. Get events per organization \n" +
                "3. Get the events of a volunteer \n" +
                "4. Get events by date \n" +
                "5. Get all events \n" +
                "6. Exit \n" +
                "Choose between 1 and 6";
    }

    public static String createSubMenuForEventsByType() {
        return "Choose a type \n" +
                "1. Clean up \n" +
                "2. Fundraiser \n" +
                "3. Food distribution \n" +
                "4. Education \n" +
                "5. Animal care \n" +
                "6. Healthcare \n" +
                "7. Concert \n" +
                "8. Exit \n";
    }

    public static String createSubMenuForVolunteers() {
        return "What is your choice? \n" +
                "1. Get volunteers by name \n" +
                "2. Get volunteers by ID \n" +
                "3. Get volunteers by events \n" +
                "4. Get all volunteers \n" +
                "Choose between 1 and 4";
    }
}