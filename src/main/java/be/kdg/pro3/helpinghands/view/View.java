package be.kdg.pro3.helpinghands.view;

public class View {
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
