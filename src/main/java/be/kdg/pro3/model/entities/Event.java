package be.kdg.pro3.model.entities;

import jdk.jfr.Category;

import java.time.LocalDate;

public class Event {
    private Long id;
    private String title;
    private LocalDate eventDate;
    private EventCategory category;
    private int maxVolunteers;
    private Status status;
    private String bannerUrl;


    public Event() {
    }

    public Event(String title, LocalDate eventDate, int maxVolunteers,
                 EventCategory category, Status status, String bannerUrl) {
        this.title = title;
        this.eventDate = eventDate;
        this.maxVolunteers = maxVolunteers;
        this.category = category;
        this.status = status;
        this.bannerUrl = bannerUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", maxVolunteers=" + maxVolunteers +
                ", status=" + status +
                ", bannerUrl='" + bannerUrl + '\'' +
                '}';
    }
}
