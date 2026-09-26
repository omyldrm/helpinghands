package be.kdg.pro3;

import be.kdg.pro3.model.entities.Event;
import be.kdg.pro3.model.entities.EventCategory;
import be.kdg.pro3.model.entities.Organization;
import be.kdg.pro3.model.entities.Volunteer;
import be.kdg.pro3.model.DataFactory;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        PrintStream io = new PrintStream(System.out);
        DataFactory.seed();
        final String menu = "What is your choice? \n" +
                "1. Get events \n" +
                "2. Get volunteers \n" +
                "3. Get organizations \n" +
                "4. Get types of events \n" +
                "5. Get events per organizations \n" +
                "6. Get volunteers per events \n" +
                "7. Get the events per volunteer \n" +
                "8. Exit \n" +
                "Choose between 1 and 8";
        System.out.println(menu);
        int answer1 = sc.nextInt();
        switch (answer1) {
            case 1:
                io.println(DataFactory.events.stream().toList());
            case 2:
                io.println(DataFactory.volunteers.stream().toList());
            case 3:
                io.println(DataFactory.organizations.stream().toList());
            case 4:
                System.out.println("Choose an event type \n" +
                        "1. Clean up" +
                        "2. Fundraiser" +
                        "3. Food distribution" +
                        "4. Education" +
                        "5. Animal care" +
                        "6. Healthcare" +
                        "7. Concert" +
                        "8. Exit");
                int answer2 = sc.nextInt();
                switch (answer2) {
                    case 1: {

                    }
                }
            case 8:
                System.out.println("Exiting");
                break;
        }
    }
}