package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.domain.Organization;
import be.kdg.pro3.helpinghands.domain.Status;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class InMemoryEventRepository implements EventRepository {
    private static final List<Event> events = new ArrayList<>();

    static {
        events.add(new Event("J. Cole: The Fall Off", LocalDate.of(2026, 10, 17), 10, EventCategory.CONCERT, Status.PLANNED, "jcole.svg.url", 1L, "Antwerp"));
        events.add(new Event("Coldplay: Music of the Spheres", LocalDate.of(2026, 7, 22), 15, EventCategory.CONCERT, Status.PLANNED, "coldplay.svg.url", 2L, "Brussels"));
        events.add(new Event("Cirque du Soleil: KOOZA", LocalDate.of(2026, 5, 9), 12, EventCategory.CONCERT, Status.PLANNED, "kooza.svg.url", 3L, "Kooza"));
        events.add(new Event("Cirque du Soleil: Alegria", LocalDate.of(2026, 3, 14), 8, EventCategory.CONCERT, Status.COMPLETED, "alegria.svg.url", 4L, "Brussels"));
        events.add(new Event("UNICEF Vaccination Drive - Lagos", LocalDate.of(2026, 4, 3), 25, EventCategory.HEALTHCARE, Status.ONGOING, "unicefvax.svg.url", 5L, "Lagos"));
        events.add(new Event("UNICEF School Supplies Program", LocalDate.of(2026, 9, 1), 20, EventCategory.EDUCATION, Status.PLANNED, "unicefedu.svg.url", 6L, "Tanger"));
        events.add(new Event("Feeding America Food Bank Drive", LocalDate.of(2026, 1, 20), 30, EventCategory.FOOD_DISTRIBUTION, Status.ONGOING, "feedingamerica.svg.url", 7L, "Houston"));
        events.add(new Event("WWF Coastal Cleanup - Great Barrier Reef", LocalDate.of(2026, 6, 8), 35, EventCategory.CLEANUP, Status.PLANNED, "wwfcleanup.svg.url", 8L, "Cape Town"));
        events.add(new Event("KDG Student quiz", LocalDate.of(2026, 12, 2), 5, EventCategory.EDUCATION, Status.PLANNED, "randomkdgphoto.svg.url", 9L, "Antwerp"));
    }

    public void addEvent(Event event) {
        Long newId = nextId(); // Calculate highest ID + 1
        Event savedEvent = new Event(event.getTitle(), event.getEventDate(), event.getMaxVolunteers(), event.getCategory(), event.getStatus(), event.getBannerUrl(), newId, event.getLocation());
        events.add(savedEvent);
    }

    public List<Event> getAllEvents() {
        return events.stream().toList();
    }

    @Override
    public List<Event> getEventsByType(EventCategory category) {
        return events.stream().filter(event -> event.getCategory() == category).toList();
    }

    @Override
    public List<Event> getEventsByOrg(Long id) {
        return events.stream()
                .filter(e -> e.getOrganization() != null)
                .filter(e -> Objects.equals(e.getOrganization().getId(), id))
                .toList();
    }

    @Override
    public List<Event> getEventsByVolunteer(String choice) {
        return events.stream()
                .filter(e -> e.getVolunteers().stream()
                        .anyMatch(v -> v.getFirstName().equalsIgnoreCase(choice)
                                || v.getLastName().equalsIgnoreCase(choice)
                                || v.getFullName().equalsIgnoreCase(choice)))
                .toList();
    }

    @Override
    public List<Event> getEventsByDate(LocalDate date) {
        return events.stream()
                .filter(e -> date.equals(e.getEventDate()))
                .toList();
    }

    @Override
    public boolean existsById(Long id) {
        return events.stream()
                .anyMatch(e -> Objects.equals(e.getId(), id));
    }

    // need this to know that next free ID = highest existing ID + 1
    @Override
    public long nextId() {
        return events.stream()
                .filter(e -> e.getId() != null)
                .mapToLong(Event::getId)
                .max()
                .orElse(0) + 1;
        // skips events without an ID, turns the rest into numbers, takes the max and adds 1
    }
}
