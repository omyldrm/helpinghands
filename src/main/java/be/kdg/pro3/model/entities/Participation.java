package be.kdg.pro3.model.entities;

import java.time.LocalDate;

public class Participation {
    private Long id;
    private int hoursLogged;
    private Role role;
    private LocalDate signupDate;

    private Volunteer volunteer;
    private Event event;

    public Participation() {
    }

    public Participation(int hoursLogged, Role role, LocalDate signupDate,
                         Volunteer volunteer, Event event) {
        this.hoursLogged = hoursLogged;
        this.role = role;
        this.signupDate = signupDate;
        this.volunteer = volunteer;
        this.event = event;
    }


    public Long getId() {
        return id;
    }

    public int getHoursLogged() {
        return hoursLogged;
    }

    public void setHoursLogged(int hoursLogged) {
        this.hoursLogged = hoursLogged;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(LocalDate signupDate) {
        this.signupDate = signupDate;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
