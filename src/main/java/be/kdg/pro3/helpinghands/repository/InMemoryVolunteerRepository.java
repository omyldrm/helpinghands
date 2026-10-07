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

    static {
        volunteers.add(new Volunteer("Omer", "Yildirim", "omer.yildirim@student.kdg.be", LocalDate.of(2005, 6, 24), true, "randomurl1", 1));
        volunteers.add(new Volunteer("Naz", "Aksinir", "naz.aksinir@student.kdg.be", LocalDate.of(2007, 11, 23), true, "randomurl2", 2));
        volunteers.add(new Volunteer("Yigit", "Yildirim", "yigit.yildirim@gmail.com", LocalDate.of(2009, 1, 24), true, "randomurl3", 3));
        volunteers.add(new Volunteer("John", "Doe", "johndoe@gmail.com", LocalDate.of(1967, 2, 14), false, "randomurl4", 4 ));
        volunteers.add(new Volunteer("Jane", "Doe", "janedoe@gmail.com", LocalDate.of(1969, 6, 4), false, "randomurl5", 5));
        volunteers.add(new Volunteer("Victor", "Osimhen", "victorosimhen@gmail.com", LocalDate.of(1997, 4, 22), false, "randomurl6", 6));
    }

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

    @Override
    public long nextId() {
        return volunteers.stream()
                .filter(v -> v.getId() != null)
                .mapToLong(Volunteer::getId)
                .max()
                .orElse(0) + 1;
    }
}
