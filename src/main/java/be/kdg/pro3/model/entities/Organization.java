package be.kdg.pro3.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Organization {
    private Long id;
    private String name;
    private LocalDate foundedDate;
    private double averageRating;
    private boolean isVerified;
    private String logoUrl;

    private List<Event> events = new ArrayList<>();

    public Organization() {
    }

    public Organization(String name, LocalDate foundedDate, double averageRating,
                        boolean isVerified, String logoUrl, Long id) {
        this.name = name;
        this.foundedDate = foundedDate;
        this.averageRating = averageRating;
        this.isVerified = isVerified;
        this.logoUrl = logoUrl;
        this.id = id;
    }

    // 1:N — add an Event to this Organization (sets both sides)
    public void addEvent(Event event) {
        this.events.add(event);
        event.setOrganization(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFoundedDate() {
        return foundedDate;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public List<Event> getEvents() {
        return events;
    }


    @Override
    public String toString() {
        return String.format("Organization #%d: %s | founded %s | rating %.1f | %s | events: %d",
                id, name, foundedDate, averageRating,
                isVerified ? "verified" : "not verified",
                events.size());
    }
}