package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Volunteer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryVolunteerRepository implements VolunteerRepository{
    private static final List<Volunteer> volunteers = new ArrayList<>();

    public void addVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    public List<Volunteer> getAllVolunteers(){
        return volunteers.stream().toList();
    }
}
