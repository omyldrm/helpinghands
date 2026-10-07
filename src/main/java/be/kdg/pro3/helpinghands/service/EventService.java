package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.EventCategory;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    void addEvent(Event event);
    List<Event> getAllEvents();
    List<Event> getEventsByType(EventCategory category);
    List<Event> getEventsByOrg(Long id);
    List<Event> getEventsByVolunteer(String choice);
    List<Event> getEventsByDate(LocalDate date);
}
