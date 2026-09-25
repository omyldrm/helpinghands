package be.kdg.pro3.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Volunteer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private boolean isStudent;
    private String avatarUrl;

    private List<Event> events = new ArrayList<>();

    public Volunteer() {
    }

    public Volunteer(String firstName, String lastName, String email,
                     LocalDate birthDate, boolean isStudent, String avatarUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.isStudent = isStudent;
        this.avatarUrl = avatarUrl;
    }

    // M:N — connect this volunteer to an event (sets both sides)
    public void addEvent(Event event) {
        this.events.add(event);
        event.addVolunteer(this);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", isStudent=" + isStudent +
                ", events=" + events.size() +
                '}';
    }
}