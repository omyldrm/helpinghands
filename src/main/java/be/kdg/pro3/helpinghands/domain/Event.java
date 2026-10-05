package be.kdg.pro3.helpinghands.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private Long id;
    private String title;
    private LocalDate eventDate;
    private int maxVolunteers;
    private EventCategory category;
    private Status status;
    private String bannerUrl;
    private String location;

    private Organization organization;
    private List<Volunteer> volunteers = new ArrayList<>();

    public Event() {
    }

    public Event(String title, LocalDate eventDate, int maxVolunteers, EventCategory category, Status status, String bannerUrl, Long id, String location) {
        this.title = title;
        this.eventDate = eventDate;
        this.maxVolunteers = maxVolunteers;
        this.category = category;
        this.status = status;
        this.bannerUrl = bannerUrl;
        this.id = id;
        this.location = location;
    }

    // called by Organization.addEvent (1:N side)
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    // called by Volunteer.addEvent (M:N side)
    public void addVolunteer(Volunteer volunteer) {
        this.volunteers.add(volunteer);
        volunteer.getEvents().add(this);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public int getMaxVolunteers() {
        return maxVolunteers;
    }

    public EventCategory getCategory() {
        return category;
    }

    public Status getStatus() {
        return status;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public Organization getOrganization() {
        return organization;
    }

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return String.format("Event #%d: %s | %s | %s | %s | org: %s | volunteers: %d/%d \n",
                id, title, eventDate, category, status,
                organization != null ? organization.getName() : "none",
                volunteers.size(), maxVolunteers);
    }
}