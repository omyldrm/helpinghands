package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Event;
import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.domain.Organization;
import be.kdg.pro3.helpinghands.domain.Status;
import be.kdg.pro3.helpinghands.repository.EventRepository;
import be.kdg.pro3.helpinghands.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
        if (event.getId() == null || eventRepository.existsById(event.getId())) {
            throw new IllegalArgumentException("An event needs a unique ID.");
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
    public Event createEvent(String title, LocalDate date, int maxVolunteers, EventCategory category,
                             Status status, String location, Long organizationId) {
        Organization organization = organizationRepository.getAllOrganizations().stream()
                .filter(o -> Objects.equals(o.getId(), organizationId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No organization found with ID " + organizationId + "."));

        Event event = new Event(title, date, maxVolunteers, category, status, null, eventRepository.nextId(), location);
        addEvent(event);
        organization.addEvent(event);
        return event;
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