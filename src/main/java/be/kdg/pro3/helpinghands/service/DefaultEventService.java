package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DefaultEventService implements EventService{
    private final EventRepository eventRepository;

    public DefaultEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void addEvent(Event event) {
        eventRepository.addEvent(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    @Override
    public List<Event> getEventsByType(EventCategory category) {
        return eventRepository.getEventsByType(category);
    }

    @Override
    public List<Event> getEventsByDate(LocalDate date) {
        return eventRepository.getEventsByDate(date);
    }

    @Override
    public List<Event> getEventsByVolunteer(String choice) {
        return eventRepository.getEventsByVolunteer(choice);
    }

    @Override
    public List<Event> getEventsByOrg(Long id) {
        return eventRepository.getEventsByOrg(id);
    }
}
