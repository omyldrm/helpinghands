package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Organization;

import java.util.List;

public interface OrganizationService {
    void addOrganization(Organization organization);
    List<Organization> getAllOrganizations();
}
