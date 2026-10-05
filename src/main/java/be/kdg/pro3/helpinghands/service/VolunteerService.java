package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Volunteer;

import java.util.List;

public interface VolunteerService {
    void addVolunteer(Volunteer volunteer);
    List<Volunteer> getAllVolunteers();
}
