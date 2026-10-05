package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Volunteer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryVolunteerRepository implements VolunteerRepository{
    private static final List<Volunteer> volunteers = new ArrayList<>();

    public void addVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    public List<Volunteer> getAllVolunteers(){
        return volunteers.stream().toList();
    }
}
