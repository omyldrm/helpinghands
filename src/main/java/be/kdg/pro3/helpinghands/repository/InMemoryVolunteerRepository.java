package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Volunteer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class InMemoryVolunteerRepository implements VolunteerRepository{
    private static final List<Volunteer> volunteers = new ArrayList<>();

    public void addVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    public List<Volunteer> getAllVolunteers(){
        return volunteers.stream().toList();
    }

    @Override
    public List<Volunteer> getVolunteersByEvent(Long id) {
        return volunteers.stream()
                .filter(v -> v.getEvents().stream()
                        .anyMatch(e -> Objects.equals(e.getId(), id)))
                .toList();
    }

    @Override
    public List<Volunteer> getVolunteersById(Long id) {
        return volunteers.stream()
                .filter(v -> Objects.equals(v.getId(), id))
                .toList();
    }

    @Override
    public List<Volunteer> getVolunteersByName(String name) {
        return volunteers.stream()
                .filter(v -> v.getFirstName().equalsIgnoreCase(name)
                        || v.getLastName().equalsIgnoreCase(name)
                        || v.getFullName().equalsIgnoreCase(name))
                .toList();
    }
}
