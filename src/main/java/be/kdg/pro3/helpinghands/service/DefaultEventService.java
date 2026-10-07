package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.repository.EventRepository;
import be.kdg.pro3.helpinghands.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DefaultEventService implements EventService{
    private final EventRepository eventRepository;
    private final OrganizationRepository organizationRepository;

    public DefaultEventService(EventRepository eventRepository, OrganizationRepository organizationRepository) {
        this.eventRepository = eventRepository;
        this.organizationRepository = organizationRepository;
    }

    @Override
    public void addEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Event can't be empty.");
        }
        if (event.getTitle() == null || event.getTitle().isBlank()) {
            throw new IllegalArgumentException("An event needs a title.");
        }
        if (event.getEventDate() == null) {
            throw new IllegalArgumentException("An event needs a date.");
        }
        if (event.getCategory() == null) {
            throw new IllegalArgumentException("An event needs a category.");
        }
        if (event.getMaxVolunteers() <= 0) {
            throw new IllegalArgumentException("Max volunteers must be greater than 0.");
        }
        eventRepository.addEvent(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    @Override
    public List<Event> getEventsByType(EventCategory category) {
        if (category == null) {
            throw new IllegalArgumentException("Choose a category.");
        }
        return eventRepository.getEventsByType(category);
    }

    @Override
    public List<Event> getEventsByDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Choose a date.");
        }
        return eventRepository.getEventsByDate(date);
    }

    @Override
    public List<Event> getEventsByVolunteer(String choice) {
        if (choice == null || choice.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
        return eventRepository.getEventsByVolunteer(choice.trim());
    }

    @Override
    public List<Event> getEventsByOrg(Long id) {
        if (id == null || !organizationRepository.existsById(id)) {
            throw new IllegalArgumentException("No organization found with ID " + id + ".");
        }
        return eventRepository.getEventsByOrg(id);
    }
}
