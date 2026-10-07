package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.repository.EventRepository;
import org.springframework.stereotype.Service;

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
    public List<Event> getEventsByType() {
        return eventRepository.getEventsByType();
    }

    @Override
    public List<Event> getEventsByDate() {
        return eventRepository.getEventsByDate();
    }

    @Override
    public List<Event> getEventsByVolunteer() {
        return eventRepository.getEventsByVolunteer();
    }

    @Override
    public List<Event> getEventsByOrg() {
        return eventRepository.getEventsByOrg();
    }
}
