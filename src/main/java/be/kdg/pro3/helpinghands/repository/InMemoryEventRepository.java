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

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getAllEvents(){
        return events.stream().toList();
    }

    @Override
    public getEventsByType(EventCategory category) {
        return events.stream().filter(event -> event.getCategory() == EventCategory.ANIMAL_CARE);
    }

    @Override
    public List<Event> getEventsByOrg(Long id) {
        return List.of();
    }

    @Override
    public List<Event> getEventsByVolunteer(String choice) {
        return List.of();
    }

    @Override
    public List<Event> getEventsByDate(LocalDate date) {
        return List.of();
    }

}
