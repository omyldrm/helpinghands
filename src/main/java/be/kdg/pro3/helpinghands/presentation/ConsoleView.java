package be.kdg.pro3.helpinghands.presentation;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.Organization;
import be.kdg.pro3.helpinghands.domain.Volunteer;
import org.springframework.stereotype.Component;

import java.util.List;

// View (MVP): only presentation code, no logic
@Component
public class ConsoleView {

    public void showMainMenu() {
        System.out.println("=== HELPING HANDS MAIN MENU ===");
        System.out.println("1. Get events");
        System.out.println("2. Get volunteers");
        System.out.println("3. Get organizations");
        System.out.println("4. Exit");
        System.out.print("Choose between 1 and 4: ");
    }

    public void showEventsMenu() {
        System.out.println("=== EVENTS ===");
        System.out.println("1. Get events by type");
        System.out.println("2. Get events per organization");
        System.out.println("3. Get the events of a volunteer");
        System.out.println("4. Get events by date");
        System.out.println("5. Get all events");
        System.out.println("6. Back");
        System.out.print("Choose between 1 and 6: ");
    }

    public void showEventTypeMenu() {
        System.out.println("=== CHOOSE A TYPE ===");
        System.out.println("1. Clean up");
        System.out.println("2. Fundraiser");
        System.out.println("3. Food distribution");
        System.out.println("4. Education");
        System.out.println("5. Animal care");
        System.out.println("6. Healthcare");
        System.out.println("7. Concert");
        System.out.println("8. Back");
        System.out.print("Choose between 1 and 8: ");
    }

    public void showVolunteersMenu() {
        System.out.println("=== VOLUNTEERS ===");
        System.out.println("1. Get volunteers by name");
        System.out.println("2. Get volunteers by ID");
        System.out.println("3. Get volunteers by event");
        System.out.println("4. Get all volunteers");
        System.out.println("5. Back");
        System.out.print("Choose between 1 and 5: ");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showEvents(List<Event> events) {
        if (events.isEmpty()) {
            System.out.println("No events found.");
            return;
        }
        for (Event event : events) {
            System.out.println(event);
        }
    }

    public void showVolunteers(List<Volunteer> volunteers) {
        if (volunteers.isEmpty()) {
            System.out.println("No volunteers found.");
            return;
        }
        for (Volunteer volunteer : volunteers) {
            System.out.println(volunteer);
        }
    }

    public void showVolunteer(Volunteer volunteer) {
        if (volunteer == null) {
            System.out.println("No volunteer found.");
            return;
        }
        System.out.println(volunteer);
    }

    public void showOrganizations(List<Organization> organizations) {
        if (organizations.isEmpty()) {
            System.out.println("No organizations found.");
            return;
        }
        for (Organization organization : organizations) {
            System.out.println(organization);
        }
    }
}