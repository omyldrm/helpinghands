package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Volunteer;

import java.util.List;

public interface VolunteerRepository {
    public void addVolunteer(Volunteer volunteer);
    public List<Volunteer> getAllVolunteers();
}
