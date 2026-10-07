package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Volunteer;
import be.kdg.pro3.helpinghands.repository.EventRepository;
import be.kdg.pro3.helpinghands.repository.VolunteerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DefaultVolunteerService implements VolunteerService{
    private final VolunteerRepository volunteerRepository;
    private final EventRepository eventRepository;

    public DefaultVolunteerService(VolunteerRepository volunteerRepository, EventRepository eventRepository){
        this.volunteerRepository = volunteerRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void addVolunteer(Volunteer volunteer) {
        if (volunteer == null) {
            throw new IllegalArgumentException("Volunteer can't be empty.");
        }
        if (volunteer.getId() == null) {
            throw new IllegalArgumentException("A volunteer needs an ID.");
        }
        if (!volunteerRepository.getVolunteersById(volunteer.getId()).isEmpty()) {
            throw new IllegalArgumentException("A volunteer with ID " + volunteer.getId() + " already exists.");
        }
        if (volunteer.getFirstName() == null || volunteer.getFirstName().isBlank()) {
            throw new IllegalArgumentException("A volunteer needs a first name.");
        }
        if (volunteer.getLastName() == null || volunteer.getLastName().isBlank()) {
            throw new IllegalArgumentException("A volunteer needs a last name.");
        }
        if (volunteer.getEmail() == null || !volunteer.getEmail().contains("@")) {
            throw new IllegalArgumentException("A volunteer needs a valid email address.");
        }
        if (volunteer.getBirthDate() != null && volunteer.getBirthDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("The birth date can't be in the future.");
        }
        volunteerRepository.addVolunteer(volunteer);
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.getAllVolunteers();
    }

    @Override
    public List<Volunteer> getVolunteersByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
        return volunteerRepository.getVolunteersByName(name.trim());
    }

    @Override
    public List<Volunteer> getVolunteersById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Give an ID.");
        }
        return volunteerRepository.getVolunteersById(id);
    }

    @Override
    public List<Volunteer> getVolunteersByEvent(Long id) {
        if (id == null || !eventRepository.existsById(id)) {
            throw new IllegalArgumentException("No event found with ID " + id + ".");
        }
        return volunteerRepository.getVolunteersByEvent(id);
    }
}
