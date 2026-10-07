package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Volunteer;

import java.time.LocalDate;
import java.util.List;

public interface VolunteerService {
    void addVolunteer(Volunteer volunteer);
    List<Volunteer> getAllVolunteers();
    List<Volunteer> getVolunteersByName(String name);
    List<Volunteer> getVolunteersById(Long id);
    List<Volunteer> getVolunteersByEvent(Long id);
    Volunteer createVolunteer(String firstName, String lastName, String email, LocalDate birthDate, boolean isStudent);
}
