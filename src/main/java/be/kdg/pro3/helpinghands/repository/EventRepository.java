package be.kdg.pro3.helpinghands.repository;


import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.domain.Status;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository {
    void addEvent(Event event);
    List<Event> getAllEvents();
    List<Event> getEventsByType(EventCategory category);
    List<Event> getEventsByOrg(Long id);
    List<Event> getEventsByVolunteer(String choice);
    List<Event> getEventsByDate(LocalDate date);
    boolean existsById(Long id);
    long nextId();
}
