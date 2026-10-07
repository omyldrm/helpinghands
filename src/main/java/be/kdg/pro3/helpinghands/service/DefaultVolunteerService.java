package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Volunteer;
import be.kdg.pro3.helpinghands.repository.VolunteerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultVolunteerService implements VolunteerService{
    private final VolunteerRepository volunteerRepository;

    public DefaultVolunteerService(VolunteerRepository volunteerRepository){
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public void addVolunteer(Volunteer volunteer) {
        volunteerRepository.addVolunteer(volunteer);
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.getAllVolunteers();
    }

    @Override
    public List<Volunteer> getVolunteersByName() {
        return volunteerRepository.getVolunteersByName();
    }

    @Override
    public List<Volunteer> getVolunteersById() {
        return volunteerRepository.getVolunteersById();
    }

    @Override
    public List<Volunteer> getVolunteersByEvent() {
        return volunteerRepository.getVolunteersByEvent();
    }
}
