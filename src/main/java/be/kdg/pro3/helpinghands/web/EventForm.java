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
}
