package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Event;

import java.util.List;

public interface EventService {
    void addEvent(Event event);
    List<Event> getAllEvents();
}
