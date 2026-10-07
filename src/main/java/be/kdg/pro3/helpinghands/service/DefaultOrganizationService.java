package be.kdg.pro3.helpinghands.service;

import be.kdg.pro3.helpinghands.domain.Organization;
import be.kdg.pro3.helpinghands.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DefaultOrganizationService implements OrganizationService {
    private final OrganizationRepository organizationRepository;

    public DefaultOrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public void addOrganization(Organization organization) {
        if (organization == null) {
            throw new IllegalArgumentException("Organization can't be empty.");
        }
        if (organization.getId() == null) {
            throw new IllegalArgumentException("An organization needs an ID.");
        }
        if (organizationRepository.existsById(organization.getId())) {
            throw new IllegalArgumentException("An organization with ID " + organization.getId() + " already exists.");
        }
        if (organization.getName() == null || organization.getName().isBlank()) {
            throw new IllegalArgumentException("An organization needs a name.");
        }
        if (organization.getFoundedDate() != null && organization.getFoundedDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("The founding date can't be in the future.");
        }
        if (organization.getAverageRating() < 0 || organization.getAverageRating() > 5) {
            throw new IllegalArgumentException("The rating must be between 0 and 5.");
        }
        organizationRepository.addOrganization(organization);
    }

    @Override
    public Organization createOrganization(String name, LocalDate foundedDate) {
        Organization organization = new Organization(name, foundedDate, 0.0, false, null, organizationRepository.nextId());
        addOrganization(organization);
        return organization;
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.getAllOrganizations();
    }
}