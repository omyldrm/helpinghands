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

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getAllEvents(){
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
}
