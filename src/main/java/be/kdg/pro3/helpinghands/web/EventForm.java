package be.kdg.pro3.helpinghands.web;

import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.domain.Status;

import java.time.LocalDate;

public class EventForm {
    private String title;
    private LocalDate eventDate;
    private int maxVolunteers;
    private EventCategory category;
    private Status status;
    private String bannerUrl;
    private String location;
    private Long organizationId;

    public EventForm(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getMaxVolunteers() {
        return maxVolunteers;
    }

    public void setMaxVolunteers(int maxVolunteers) {
        this.maxVolunteers = maxVolunteers;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
