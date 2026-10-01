package be.kdg.pro3.model;

import be.kdg.pro3.model.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DataFactory {
    public static List<Volunteer> volunteers = new ArrayList<>();
    public static List<Event> events = new ArrayList<>();
    public static List<Organization> organizations = new ArrayList<>();

    public static void seed(){
        // volunteers
        Volunteer volunteer1 = new Volunteer("Omer", "Yildirim", "omer.yildirim@student.kdg.be", LocalDate.of(2005, 6, 24), true, "randomurl1", 1);
        Volunteer volunteer2 = new Volunteer("Naz", "Aksinir", "naz.aksinir@student.kdg.be", LocalDate.of(2007, 11, 23), true, "randomurl2", 2);
        Volunteer volunteer3 = new Volunteer("Yigit", "Yildirim", "yigit.yildirim@gmail.com", LocalDate.of(2009, 1, 24), true, "randomurl3", 3 );
        Volunteer volunteer4 = new Volunteer("John", "Doe", "johndoe@gmail.com", LocalDate.of(1967, 2, 14), false, "randomurl4", 4 );
        Volunteer volunteer5 = new Volunteer("Jane", "Doe", "janedoe@gmail.com", LocalDate.of(1969, 6, 4), false, "randomurl5", 5);
        Volunteer volunteer6 = new Volunteer("Victor", "Osimhen", "victorosimhen@gmail.com", LocalDate.of(1997, 4, 22), false, "randomurl6", 6);

        // organizations
        Organization organization1 = new Organization("Live Nation", LocalDate.of(2010, 1, 25), 3.9, true, "https://cdn.prod.website-files.com/69fcec01601a440674da336f/6a060e72c4e409d4794af40e_LN_Logo_Primary_Red-Black_web.webp", 1L);
        Organization organization2 = new Organization("Cirque du Soleil", LocalDate.of(1984, 1, 25), 4, true, "https://upload.wikimedia.org/wikipedia/fr/1/1c/Logo_Cirque_du_Soleil.svg?utm_source=fr.wikipedia.org&utm_campaign=index&utm_content=original", 2L);
        Organization organization3 = new Organization("UNICEF", LocalDate.of(1946, 1, 25), 4.5, true, "https://thumb.wikimedia.org/wikipedia/commons/thumb/3/36/Logo_of_UNICEF_%28cropped%29.svg/3840px-Logo_of_UNICEF_%28cropped%29.svg.png?utm_source=commons.wikimedia.org&utm_campaign=index&utm_content=thumbnail", 3L);
        Organization organization4 = new Organization("Feeding America", LocalDate.of(1979, 1, 1), 2.3, true, "https://i0.wp.com/www.fsproduce.com/wp-content/uploads/2015/05/Feeding_America_logo.svg.png?ssl=1", 4L);
        Organization organization5 = new Organization("World Wildlife Fund", LocalDate.of(1961, 4, 29), 5, true, "https://thumb.wikimedia.org/wikipedia/de/thumb/0/06/WWF_Logo.svg/1920px-WWF_Logo.svg.png?utm_source=de.wikipedia.org&utm_campaign=index&utm_content=thumbnail", 5L);
        Organization organization6 = new Organization("KDG", LocalDate.of(1999, 9, 9), 1.2, false, "https://upload.wikimedia.org/wikipedia/commons/5/5b/Logo_Karel_de_Grote_Hogeschool.png?utm_source=commons.wikimedia.org&utm_campaign=index&utm_content=original", 6L);

        // events
        Event event1 = new Event("J. Cole: The Fall Off", LocalDate.of(2026, 10, 17), 10, EventCategory.CONCERT, Status.PLANNED, "jcole.svg.url", 1L, "Antwerp");
        Event event2 = new Event("Coldplay: Music of the Spheres", LocalDate.of(2026, 7, 22), 15, EventCategory.CONCERT, Status.PLANNED, "coldplay.svg.url", 2L, "Brussels");
        Event event3 = new Event("Cirque du Soleil: KOOZA", LocalDate.of(2026, 5, 9), 12, EventCategory.CONCERT, Status.PLANNED, "kooza.svg.url", 3L, "Kooza");
        Event event4 = new Event("Cirque du Soleil: Alegria", LocalDate.of(2026, 3, 14), 8, EventCategory.CONCERT, Status.COMPLETED, "alegria.svg.url", 4L, "Brussels");
        Event event5 = new Event("UNICEF Vaccination Drive - Lagos", LocalDate.of(2026, 4, 3), 25, EventCategory.HEALTHCARE, Status.ONGOING, "unicefvax.svg.url", 5L, "Lagos");
        Event event6 = new Event("UNICEF School Supplies Program", LocalDate.of(2026, 9, 1), 20, EventCategory.EDUCATION, Status.PLANNED, "unicefedu.svg.url", 6L, "Tanger");
        Event event7 = new Event("Feeding America Food Bank Drive", LocalDate.of(2026, 1, 20), 30, EventCategory.FOOD_DISTRIBUTION, Status.ONGOING, "feedingamerica.svg.url", 7L, "Houston");
        Event event8 = new Event("WWF Coastal Cleanup - Great Barrier Reef", LocalDate.of(2026, 6, 8), 35, EventCategory.CLEANUP, Status.PLANNED, "wwfcleanup.svg.url", 8L, "Cape Town");
        Event event9 = new Event("KDG Student quiz", LocalDate.of(2026, 12, 2), 5, EventCategory.EDUCATION, Status.PLANNED, "randomkdgphoto.svg.url", 9L, "Antwerp");


        // adding the list of events to the list
        events.addAll(List.of(event1, event2, event3, event4, event5, event6, event7, event8, event9));
        // adding the list of volunteers to the list
        volunteers.addAll(List.of(volunteer1, volunteer2, volunteer3, volunteer4, volunteer5, volunteer6));
        // adding the list of organizations to the list
        organizations.addAll(List.of(organization1, organization2, organization3, organization4, organization5, organization6));

        // adding the volunteers to the events (M:N)
        event1.addVolunteer(volunteer1);
        event1.addVolunteer(volunteer2);
        event2.addVolunteer(volunteer3);
        event2.addVolunteer(volunteer4);
        event3.addVolunteer(volunteer4);
        event3.addVolunteer(volunteer3);
        event4.addVolunteer(volunteer5);
        event5.addVolunteer(volunteer6);
        event5.addVolunteer(volunteer5);
        event6.addVolunteer(volunteer4);
        event6.addVolunteer(volunteer1);
        event7.addVolunteer(volunteer1);
        event8.addVolunteer(volunteer2);
        event9.addVolunteer(volunteer2);

        // matching the organizers to the events ( 1:M )
        organization1.addEvent(event1);
        organization1.addEvent(event2);
        organization2.addEvent(event3);
        organization2.addEvent(event4);
        organization3.addEvent(event5);
        organization3.addEvent(event6);
        organization4.addEvent(event7);
        organization5.addEvent(event8);
        organization6.addEvent(event9);

        // so now each event has volunteers and volunteers can have multiple events , organizers have events while each event has 1 organizer


    }
}