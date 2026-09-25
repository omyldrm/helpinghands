package be.kdg.pro3.model;

import be.kdg.pro3.model.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataFactory {

    public static List<Volunteer> volunteers = new ArrayList<>();
    public static List<Event> events = new ArrayList<>();

    // helper list so the 1:N side is reachable (and can show an org with 0 events)
    public static List<Organization> organizations = new ArrayList<>();

    public static void seed() {
        // Organizations
        Organization redCross = new Organization("International Red Cross",
                LocalDate.of(1863, 2, 17), 4.8, true,
                "https://picsum.photos/seed/redcross/200");
        Organization msf = new Organization("Doctors Without Borders",
                LocalDate.of(1971, 12, 22), 4.7, true,
                "https://picsum.photos/seed/msf/200");
        Organization unicef = new Organization("UNICEF",
                LocalDate.of(1946, 12, 11), 4.6, true,
                "https://picsum.photos/seed/unicef/200");
        Organization habitat = new Organization("Habitat for Humanity",
                LocalDate.of(1976, 9, 1), 4.5, true,
                "https://picsum.photos/seed/habitat/200");
        Organization greenpeace = new Organization("Greenpeace",
                LocalDate.of(1971, 9, 15), 4.3, false,
                "https://picsum.photos/seed/greenpeace/200");
        Organization wwf = new Organization("World Wildlife Fund",
                LocalDate.of(1961, 4, 29), 4.5, true,
                "https://picsum.photos/seed/wwf/200"); // 0 events

        organizations.add(redCross);
        organizations.add(msf);
        organizations.add(unicef);
        organizations.add(habitat);
        organizations.add(greenpeace);
        organizations.add(wwf);

        // Events (1:N attached to an organization)
        Event beachCleanup = new Event("Beach Cleanup - Bali",
                LocalDate.of(2026, 4, 18), 30, EventCategory.CLEANUP, Status.PLANNED,
                "https://picsum.photos/seed/beach/400/200");
        Event bloodDrive = new Event("Blood Donation Drive - Nairobi",
                LocalDate.of(2026, 3, 10), 20, EventCategory.HEALTHCARE, Status.COMPLETED,
                "https://picsum.photos/seed/blood/400/200");
        Event foodDistribution = new Event("Food Distribution - Manila",
                LocalDate.of(2026, 1, 15), 25, EventCategory.FOOD_DISTRIBUTION, Status.ONGOING,
                "https://picsum.photos/seed/food/400/200");
        Event jazzConcert = new Event("Charity Jazz Night - New Orleans",
                LocalDate.of(2026, 5, 22), 15, EventCategory.CONCERT, Status.PLANNED,
                "https://picsum.photos/seed/jazz/400/200");
        Event rockConcert = new Event("Benefit Rock Concert - Tokyo",
                LocalDate.of(2026, 6, 14), 18, EventCategory.CONCERT, Status.PLANNED,
                "https://picsum.photos/seed/rock/400/200");
        Event classicalConcert = new Event("Classical Charity Gala - Vienna",
                LocalDate.of(2026, 2, 28), 12, EventCategory.CONCERT, Status.COMPLETED,
                "https://picsum.photos/seed/classical/400/200");
        Event natureWalk = new Event("Rainforest Education Walk - Costa Rica",
                LocalDate.of(2026, 6, 5), 40, EventCategory.EDUCATION, Status.PLANNED,
                "https://picsum.photos/seed/rainforest/400/200"); // 0 volunteers
        Event soupKitchen = new Event("Community Soup Kitchen - Toronto",
                LocalDate.of(2026, 1, 20), 10, EventCategory.FOOD_DISTRIBUTION, Status.ONGOING,
                "https://picsum.photos/seed/soup/400/200");

        msf.addEvent(foodDistribution);
        msf.addEvent(soupKitchen);                     // org with many events
        unicef.addEvent(jazzConcert);
        unicef.addEvent(classicalConcert);
        habitat.addEvent(rockConcert);
        greenpeace.addEvent(beachCleanup);
        greenpeace.addEvent(natureWalk);

        events.add(beachCleanup);
        events.add(bloodDrive);
        events.add(foodDistribution);
        events.add(jazzConcert);
        events.add(rockConcert);
        events.add(classicalConcert);
        events.add(natureWalk);
        events.add(soupKitchen);

        // Volunteers
        Volunteer maya = new Volunteer("Maya", "Rodriguez", "maya.rodriguez@gmail.com",
                LocalDate.of(2002, 3, 14), true, "https://randomuser.me/api/portraits/women/44.jpg");
        Volunteer kenji = new Volunteer("Kenji", "Tanaka", "kenji.tanaka@outlook.com",
                LocalDate.of(1995, 7, 2), false, "https://randomuser.me/api/portraits/men/32.jpg");
        Volunteer amara = new Volunteer("Amara", "Okafor", "amara.okafor@gmail.com",
                LocalDate.of(2003, 11, 25), true, "https://randomuser.me/api/portraits/women/68.jpg");
        Volunteer liam = new Volunteer("Liam", "O'Brien", "liam.obrien@gmail.com",
                LocalDate.of(1998, 1, 9), false, "https://randomuser.me/api/portraits/men/76.jpg");
        Volunteer sofia = new Volunteer("Sofia", "Rossi", "sofia.rossi@hotmail.com",
                LocalDate.of(2000, 5, 30), true, "https://randomuser.me/api/portraits/women/12.jpg"); // 0 events
        Volunteer omer = new Volunteer("Omar", "Hassan", "omar.hassan@gmail.com",
                LocalDate.of(1997, 9, 18), false, "https://randomuser.me/api/portraits/men/5.jpg");   // 1 event

        volunteers.add(maya);
        volunteers.add(kenji);
        volunteers.add(amara);
        volunteers.add(liam);
        volunteers.add(sofia);
        volunteers.add(omer);

        // M:N relationships (Volunteer <-> Event)
        maya.addEvent(beachCleanup);
        maya.addEvent(jazzConcert);
        maya.addEvent(foodDistribution);

        kenji.addEvent(rockConcert);
        kenji.addEvent(beachCleanup);

        amara.addEvent(foodDistribution);
        amara.addEvent(soupKitchen);
        amara.addEvent(bloodDrive);

        liam.addEvent(classicalConcert);
        liam.addEvent(rockConcert);

        omer.addEvent(bloodDrive);

        // sofia: signed up for nothing yet (0 events)
    }
}