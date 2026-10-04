package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.domain.Organization;
import be.kdg.pro3.helpinghands.domain.Status;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEventRepository implements EventRepository {
    private static final List<Event> events = new ArrayList<>();

    static {
        events.add(new Event("J. Cole: The Fall Off", LocalDate.of(2026, 10, 17), 10, EventCategory.CONCERT, Status.PLANNED, "jcole.svg.url", 1, "Antwerp"));
        events.add(new Event("Coldplay: Music of the Spheres", LocalDate.of(2026, 7, 22), 15, EventCategory.CONCERT, Status.PLANNED, "coldplay.svg.url", 2, "Brussels"));
        events.add(new Event("Cirque du Soleil: KOOZA", LocalDate.of(2026, 5, 9), 12, EventCategory.CONCERT, Status.PLANNED, "kooza.svg.url", 3, "Kooza"));
        events.add(new Event("Cirque du Soleil: Alegria", LocalDate.of(2026, 3, 14), 8, EventCategory.CONCERT, Status.COMPLETED, "alegria.svg.url", 4, "Brussels"));
        events.add(new Event("UNICEF Vaccination Drive - Lagos", LocalDate.of(2026, 4, 3), 25, EventCategory.HEALTHCARE, Status.ONGOING, "unicefvax.svg.url", 5, "Lagos"));
        events.add(new Event("UNICEF School Supplies Program", LocalDate.of(2026, 9, 1), 20, EventCategory.EDUCATION, Status.PLANNED, "unicefedu.svg.url", 6, "Tanger"));
        events.add(new Event("Feeding America Food Bank Drive", LocalDate.of(2026, 1, 20), 30, EventCategory.FOOD_DISTRIBUTION, Status.ONGOING, "feedingamerica.svg.url", 7, "Houston"));
        events.add(new Event("WWF Coastal Cleanup - Great Barrier Reef", LocalDate.of(2026, 6, 8), 35, EventCategory.CLEANUP, Status.PLANNED, "wwfcleanup.svg.url", 8, "Cape Town"));
        events.add(new Event("KDG Student quiz", LocalDate.of(2026, 12, 2), 5, EventCategory.EDUCATION, Status.PLANNED, "randomkdgphoto.svg.url", 9, "Antwerp"));
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getAllEvents(){
        return events.stream().toList();
    }
}
