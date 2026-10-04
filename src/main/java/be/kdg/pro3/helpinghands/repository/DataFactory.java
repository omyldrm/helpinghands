package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataFactory {
    private final EventRepository eventRepository;
    private final OrganizationRepository organizationRepository;
    private final VolunteerRepository volunteerRepository;

    public DataFactory(EventRepository eventRepository, OrganizationRepository organizationRepository, VolunteerRepository volunteerRepository) {
        this.eventRepository = eventRepository;
        this.organizationRepository = organizationRepository;
        this.volunteerRepository = volunteerRepository;
    }

    public static void seed(){


    }
}