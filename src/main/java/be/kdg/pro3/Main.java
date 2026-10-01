package be.kdg.pro3;

import be.kdg.pro3.model.DataFactory;
import be.kdg.pro3.model.entities.EventCategory;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static void main() {
        PrintStream io = new PrintStream(System.out);
        DataFactory.seed();
        boolean running = true;
        System.out.println(createMainMenu());
        int answer1 = sc.nextInt();
            do {
                switch (answer1) {
                    case 1:
                        // the menu for event options
                        System.out.println(createSubMenuForEvents());
                        int answer2 = sc.nextInt();
                        switch (answer2) {
                            case 1:
                                System.out.println(createSubMenuForEventsByType());
                                int answer3 = sc.nextInt();
                                switch (answer3) {
                                    // selecting a type
                                    case 1:
                                        io.println(DataFactory.events.stream().filter(e -> e.getCategory() == EventCategory.CLEANUP).toList());
                                }
                                // other cases
                        }
                    case 2:
                        // menu for volunteers
                        System.out.println(createSubMenuForVolunteers());
                    case 3:
                        io.println(DataFactory.organizations.stream().toList());
                    case 4:

                    case 8:
                        System.out.println("Exiting");
                        running = false;
                }
            } while (running);
    }
    public static String createMainMenu(){
        return "What is your choice? \n" +
                "1. Get events \n" +
                "2. Get volunteers \n" +
                "3. Get organizations \n" +
                "4. Exit \n" +
                "Choose between 1 and 4";
    }

    public static void openMainMenu(){
        System.out.println(createMainMenu());
        int answer = sc.nextInt();

    }

    public static String createSubMenuForEvents(){
        return "What is your choice? \n" +
                "1. Get events by type \n" +
                "2. Get events per organization \n" +
                "3. Get the events of a volunteer \n" +
                "4. Get events by date \n" +
                "5. Get all events \n" +
                "6. Exit \n" +
                "Choose between 1 and 6";
    }

    public static String createSubMenuForEventsByType(){
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

    public static String createSubMenuForVolunteers(){
        return "What is your choice?" +
                "1. Get volunteers by name \n" +
                "2. Get volunteers by ID \n" +
                "3. Get volunteers by events \n" +
                "4. Get all volunteers \n" +
                "Choose between 1 and 4";
    }
}
