package be.kdg.pro3.helpinghands.presentation.web;

import be.kdg.pro3.helpinghands.domain.EventCategory;
import be.kdg.pro3.helpinghands.domain.Status;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EventForm {

    @NotBlank(message = "{validation.event.title.notblank}") // not null, not empty, not only spaces
    @Size(min = 3, max = 100, message = "{validation.event.title.size}") // length between 3 and 100
    private String title;

    @NotNull(message = "{validation.event.date.notnull}") // date must be filled in
    @Future(message = "{validation.event.date.future}") // date must be after today
    @DateTimeFormat(pattern = "yyyy-MM-dd") // matches the format of input type="date"
    private LocalDate eventDate;

    @NotBlank(message = "{validation.event.location.notblank}")
    private String location;

    @NotNull(message = "{validation.event.maxVolunteers.notnull}")
    @Min(value = 1, message = "{validation.event.maxVolunteers.min}") // at least 1
    @Max(value = 500, message = "{validation.event.maxVolunteers.max}") // at most 500
    private Integer maxVolunteers;

    @NotNull(message = "{validation.event.category.notnull}") // a category must be selected
    private EventCategory category;

    @NotNull(message = "{validation.event.status.notnull}") // a status must be selected
    private Status status;

    @NotNull(message = "{validation.event.organization.notnull}") // an organization must be selected
    private Long organizationId;

    // optional
    private String bannerUrl;

    // we need this for form binding in sb
    public EventForm() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMaxVolunteers() {
        return maxVolunteers;
    }

    public void setMaxVolunteers(Integer maxVolunteers) {
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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }
}