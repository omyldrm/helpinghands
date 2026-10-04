package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Organization;

import java.util.List;

public interface OrganizationRepository{
    public void addOrganization(Organization organization);
    public List<Organization> getAllOrganizations();
}
