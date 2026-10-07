package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Organization;

import java.time.LocalDate;
import java.util.List;

public interface OrganizationService {
    void addOrganization(Organization organization);
    List<Organization> getAllOrganizations();
    Organization createOrganization(String name, LocalDate foundedDate);
}
