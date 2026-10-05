package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataFactory {
    private final EventRepository eventRepository;
    private final OrganizationRepository organizationRepository;
    private final VolunteerRepository volunteerRepository;

    public DataFactory(EventRepository eventRepository, OrganizationRepository organizationRepository, VolunteerRepository volunteerRepository) {
        this.eventRepository = eventRepository;
        this.organizationRepository = organizationRepository;
        this.volunteerRepository = volunteerRepository;
    }


    public static void seed(){
        Organization org1 = new Organization("Live Nation", LocalDate.of(2010, 1, 25), 3.9, true, "https://cdn.prod.website-files.com/69fcec01601a440674da336f/6a060e72c4e409d4794af40e_LN_Logo_Primary_Red-Black_web.webp", 1L);
        Organization org2 = new Organization("Cirque du Soleil", LocalDate.of(1984, 1, 25), 4, true, "https://upload.wikimedia.org/wikipedia/fr/1/1c/Logo_Cirque_du_Soleil.svg?utm_source=fr.wikipedia.org&utm_campaign=index&utm_content=original", 2L);
        Organization org3 = new Organization("UNICEF", LocalDate.of(1946, 1, 25), 4.5, true, "https://thumb.wikimedia.org/wikipedia/commons/thumb/3/36/Logo_of_UNICEF_%28cropped%29.svg/3840px-Logo_of_UNICEF_%28cropped%29.svg.png?utm_source=commons.wikimedia.org&utm_campaign=index&utm_content=thumbnail", 3L);
        Organization org4 = new Organization("Feeding America", LocalDate.of(1979, 1, 1), 2.3, true, "https://i0.wp.com/www.fsproduce.com/wp-content/uploads/2015/05/Feeding_America_logo.svg.png?ssl=1", 4L);
        Organization org5 = new Organization("World Wildlife Fund", LocalDate.of(1961, 4, 29), 5, true, "https://thumb.wikimedia.org/wikipedia/de/thumb/0/06/WWF_Logo.svg/1920px-WWF_Logo.svg.png?utm_source=de.wikipedia.org&utm_campaign=index&utm_content=thumbnail", 5L);
        Organization org6 = new Organization("KDG", LocalDate.of(1999, 9, 9), 1.2, false, "https://upload.wikimedia.org/wikipedia/commons/5/5b/Logo_Karel_de_Grote_Hogeschool.png?utm_source=commons.wikimedia.org&utm_campaign=index&utm_content=original", 6L);

        Event e1 = new Event("J. Cole: The Fall Off", LocalDate.of(2026, 10, 17), 10, EventCategory.CONCERT, Status.PLANNED, "jcole.svg.url", 1L, "Antwerp");
        Event e2 = new Event("Coldplay: Music of the Spheres", LocalDate.of(2026, 7, 22), 15, EventCategory.CONCERT, Status.PLANNED, "coldplay.svg.url", 2L, "Brussels");
        Event e3 = new Event("Cirque du Soleil: KOOZA", LocalDate.of(2026, 5, 9), 12, EventCategory.CONCERT, Status.PLANNED, "kooza.svg.url", 3L, "Kooza");
        Event e4 = new Event("Cirque du Soleil: Alegria", LocalDate.of(2026, 3, 14), 8, EventCategory.CONCERT, Status.COMPLETED, "alegria.svg.url", 4L, "Brussels");
        Event e5 = new Event("UNICEF Vaccination Drive - Lagos", LocalDate.of(2026, 4, 3), 25, EventCategory.HEALTHCARE, Status.ONGOING, "unicefvax.svg.url", 5L, "Lagos");
        Event e6 = new Event("UNICEF School Supplies Program", LocalDate.of(2026, 9, 1), 20, EventCategory.EDUCATION, Status.PLANNED, "unicefedu.svg.url", 6L, "Tanger");
        Event e7 = new Event("Feeding America Food Bank Drive", LocalDate.of(2026, 1, 20), 30, EventCategory.FOOD_DISTRIBUTION, Status.ONGOING, "feedingamerica.svg.url", 7L, "Houston");
        Event e8 = new Event("WWF Coastal Cleanup - Great Barrier Reef", LocalDate.of(2026, 6, 8), 35, EventCategory.CLEANUP, Status.PLANNED, "wwfcleanup.svg.url", 8L, "Cape Town");
        Event e9 = new Event("KDG Student quiz", LocalDate.of(2026, 12, 2), 5, EventCategory.EDUCATION, Status.PLANNED, "randomkdgphoto.svg.url", 9L, "Antwerp");

        Volunteer v1 = new Volunteer("Omer", "Yildirim", "omer.yildirim@student.kdg.be", LocalDate.of(2005, 6, 24), true, "randomurl1", 1);
        Volunteer v2 = new Volunteer("Naz", "Aksinir", "naz.aksinir@student.kdg.be", LocalDate.of(2007, 11, 23), true, "randomurl2", 2);
        Volunteer v3 = new Volunteer("Yigit", "Yildirim", "yigit.yildirim@gmail.com", LocalDate.of(2009, 1, 24), true, "randomurl3", 3);
        Volunteer v4 = new Volunteer("John", "Doe", "johndoe@gmail.com", LocalDate.of(1967, 2, 14), false, "randomurl4", 4 );
        Volunteer v5 = new Volunteer("Jane", "Doe", "janedoe@gmail.com", LocalDate.of(1969, 6, 4), false, "randomurl5", 5);
        Volunteer v6 = new Volunteer("Victor", "Osimhen", "victorosimhen@gmail.com", LocalDate.of(1997, 4, 22), false, "randomurl6", 6);
    }
}