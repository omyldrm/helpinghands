package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Organization;
import be.kdg.pro3.helpinghands.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultOrganizationService implements OrganizationService {
    private final OrganizationRepository organizationRepository;

    public DefaultOrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public void addOrganization(Organization organization) {
        organizationRepository.addOrganization(organization);
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.getAllOrganizations();
    }
}
